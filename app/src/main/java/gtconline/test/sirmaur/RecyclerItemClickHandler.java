package gtconline.test.sirmaur;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RecyclerItemClickHandler {

        private final RecyclerView mRecyclerView;
        private OnItemClickListener mOnItemClickListener;
        private OnItemLongClickListener mOnItemLongClickListener;
        private View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    // ask the RecyclerView for the viewHolder of this view.
                    // then use it to get the position for the adapter
                    RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(v);
                    mOnItemClickListener.onItemClicked(mRecyclerView, holder.getAdapterPosition(), v);
                }
            }
        };
        private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mOnItemLongClickListener != null) {
                    RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(v);
                    return mOnItemLongClickListener.onItemLongClicked(mRecyclerView, holder.getAdapterPosition(), v);
                }
                return false;
            }
        };
        private RecyclerView.OnChildAttachStateChangeListener mAttachListener
                = new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {
                // every time a new child view is attached add click listeners to it
                if (mOnItemClickListener != null) {
                    view.setOnClickListener(mOnClickListener);
                }
                if (mOnItemLongClickListener != null) {
                    view.setOnLongClickListener(mOnLongClickListener);
                }
            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {

            }
        };


        private RecyclerItemClickHandler(RecyclerView recyclerView) {
            mRecyclerView = recyclerView;
            // the ID must be declared in XML, used to avoid
            // replacing the ItemClickSupport without removing
            // the old one from the RecyclerView
            mRecyclerView.setTag(R.id.item_click_support, this);
            mRecyclerView.addOnChildAttachStateChangeListener(mAttachListener);
        }

        public static RecyclerItemClickHandler addTo(RecyclerView view) {
            // if there's already an ItemClickSupport attached
            // to this RecyclerView do not replace it, use it
            RecyclerItemClickHandler support = (RecyclerItemClickHandler) view.getTag(R.id.item_click_support);
            if (support == null) {
                support = new RecyclerItemClickHandler(view);
            }
            return support;
        }

        public static RecyclerItemClickHandler removeFrom(RecyclerView view) {
            RecyclerItemClickHandler support = (RecyclerItemClickHandler) view.getTag(R.id.item_click_support);
            if (support != null) {
                support.detach(view);
            }
            return support;
        }

        public RecyclerItemClickHandler setOnItemClickListener(OnItemClickListener listener) {
            mOnItemClickListener = listener;
            return this;
        }

        public RecyclerItemClickHandler setOnItemLongClickListener(OnItemLongClickListener listener) {
            mOnItemLongClickListener = listener;
            return this;
        }

        private void detach(RecyclerView view) {
            view.removeOnChildAttachStateChangeListener(mAttachListener);
            view.setTag(R.id.item_click_support, null);
        }

        public interface OnItemClickListener {

            void onItemClicked(RecyclerView recyclerView, int position, View v);
        }

        public interface OnItemLongClickListener {

            boolean onItemLongClicked(RecyclerView recyclerView, int position, View v);
        }

}
