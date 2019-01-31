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

public class howToReachByRoad extends Fragment {


    ArrayList<AboutInfo> byRoadList;
    RecyclerView byRoadView;

    public howToReachByRoad() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_br_roard, container, false);

        byRoadList=new ArrayList<>();

        byRoadView=view.findViewById(R.id.roadView);

        fillByRoadList();
        byRoadView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        byRoadView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        byRoadView.setAdapter(new AboutInfoAdapter(byRoadList));


        return view;
    }


    public void fillByRoadList()
    {
        byRoadList.add(new AboutInfo("","It is 90 Km from Chandigarh, 90 Km from Dehradun, 135 Km from Shimla and 65 Km from Ambala."));
        byRoadList.add(new AboutInfo("",""));
    }


}
