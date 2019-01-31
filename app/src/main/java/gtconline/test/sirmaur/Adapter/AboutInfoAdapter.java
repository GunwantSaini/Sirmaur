package gtconline.test.sirmaur.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import gtconline.test.sirmaur.Pojo.AboutInfo;
import gtconline.test.sirmaur.R;

public class AboutInfoAdapter extends RecyclerView.Adapter<AboutInfoAdapter.MyViewHolder> {


    ArrayList<AboutInfo> aboutInfoList;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.about_info_row, viewGroup, false));
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.set(aboutInfoList.get(i));

    }

    @Override
    public int getItemCount() {
        return aboutInfoList.size();
    }





    public AboutInfoAdapter(ArrayList<AboutInfo> aboutInfoList)
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


            void set(AboutInfo aboutInfo)
            {
                title.setText(aboutInfo.getTitle());
                description.setText(aboutInfo.getDescription());
            }


        }




}
