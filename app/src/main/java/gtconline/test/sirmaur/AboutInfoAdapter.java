package gtconline.test.sirmaur;

import android.support.annotation.NonNull;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AboutInfoAdapter extends RecyclerView.Adapter<AboutInfoAdapter.MyViewHolder> {


    ArrayList<AboutInfo> aboutInfoList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }





    public AboutInfoAdapter(ArrayList aboutInfoList)
    {
        this.aboutInfoList=aboutInfoList;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView title, description;

            public MyViewHolder(View view) {
                super(view);
                title = view.findViewById(R.id.title_info);
                description = view.findViewById(R.id.description_info);
            }
        }




}
