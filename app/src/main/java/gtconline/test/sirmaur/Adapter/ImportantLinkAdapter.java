package gtconline.test.sirmaur.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.PluralsRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gtconline.test.sirmaur.Pojo.ImportntLinkInfo;
import gtconline.test.sirmaur.R;
import gtconline.test.sirmaur.Ui.Activity.PlaceDetails;

public class ImportantLinkAdapter extends RecyclerView.Adapter<ImportantLinkAdapter.MyViewHolder> {

    ArrayList<ImportntLinkInfo> importantLinksList;

    Context context;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ImportantLinkAdapter.MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.imp_link_row, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {


        myViewHolder.set(importantLinksList.get(i));

    }

    @Override
    public int getItemCount() {
        return importantLinksList.size();
    }

    public ImportantLinkAdapter(ArrayList<ImportntLinkInfo> impLinksList, Context context)
    {
        this.importantLinksList=impLinksList;
        this.context=context;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView linkName;

        public MyViewHolder(View view) {
            super(view);
            linkName = view.findViewById(R.id.linkName);
        }


        void set(ImportntLinkInfo importntLinkInfo)
        {
            linkName.setText(importntLinkInfo.getLinkName());

        }


    }






}
