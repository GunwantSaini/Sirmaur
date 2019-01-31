package gtconline.test.sirmaur.Ui.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import gtconline.test.sirmaur.Pojo.AboutInfo;
import gtconline.test.sirmaur.Adapter.AboutInfoAdapter;
import gtconline.test.sirmaur.R;


public class HowToRachByTrain extends Fragment {


    ArrayList<AboutInfo> trainList;
    RecyclerView trainView;

    public HowToRachByTrain() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_how_to_rach_by_train, container, false);
        trainView=view.findViewById(R.id.trainView);

        trainList=new ArrayList<AboutInfo>();


        fillTrainList();

        trainView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        trainView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        trainView.setAdapter(new AboutInfoAdapter(trainList));

        return view;
    }


    public void fillTrainList()
    {
        trainList.add(new AboutInfo("Nearest Railway Station","Nearest Railway Staions are Ambala, Kalka Ji, Yamuna Nagar, Dehradun & Shimla,  which are connected by a regular bus service."));
    }


}
