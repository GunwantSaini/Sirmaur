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

import gtconline.test.sirmaur.Adapter.AboutInfoAdapter;
import gtconline.test.sirmaur.Pojo.AboutInfo;
import gtconline.test.sirmaur.R;


public class HowToReachByAir extends Fragment {



    RecyclerView airView;
    ArrayList airList;

    public HowToReachByAir() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        airList=new ArrayList<AboutInfo>();
        View view= inflater.inflate(R.layout.fragment_how_to_reach_by_air, container, false);

        airView=view.findViewById(R.id.airView);

        fillairList();

        airView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        airView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        airView.setAdapter(new AboutInfoAdapter(airList));

        return view;
    }


    public void fillairList()
    {
        airList.add(new AboutInfo("Nearest Airport","Nearest Airports are Chandigarh, Dehradun & Shimla , which are connected by a regular bus or taxi service."));

    }




}
