package gtconline.test.sirmaur.Adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import gtconline.test.sirmaur.R;


public class GridAdapter extends BaseAdapter {

    Context context;
    ArrayList arrayList;

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public GridAdapter(Context context, ArrayList arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=convertView;

        if (view == null) {
            view=LayoutInflater.from(context).inflate(R.layout.imp_link_row,parent,false);
        }

        TextView textView=view.findViewById(R.id.linkName);

        textView.setText(arrayList.get(position).toString());

        return view;
    }



}
