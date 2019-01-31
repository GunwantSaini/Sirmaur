package gtconline.test.sirmaur.Ui.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import gtconline.test.sirmaur.Adapter.AboutInfoAdapter;
import gtconline.test.sirmaur.Adapter.ImportantLinkAdapter;
import gtconline.test.sirmaur.Pojo.ImportntLinkInfo;
import gtconline.test.sirmaur.R;
import gtconline.test.sirmaur.RecyclerItemClickHandler;
import gtconline.test.sirmaur.Ui.Activity.PlaceDetails;


public class TouristPlaces extends Fragment {


    ArrayList<ImportntLinkInfo> touristPlacesList;

    public TouristPlaces() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tourist_places, container, false);


        RecyclerView touristPlacesLv;

        touristPlacesList=new ArrayList<>();
         fillTouristPlaces();

        touristPlacesLv=view.findViewById(R.id.touristPlacesView);


        RecyclerItemClickHandler.addTo(touristPlacesLv).setOnItemClickListener(new RecyclerItemClickHandler.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                getActivity().startActivity(new Intent(getContext(),PlaceDetails.class).putExtra("placeName",touristPlacesList.get(position).getLinkName()));

            }
        });

        touristPlacesLv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        touristPlacesLv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        touristPlacesLv.setAdapter(new ImportantLinkAdapter(touristPlacesList,getActivity()));

        return view;
    }



    public void fillTouristPlaces()
    {
        touristPlacesList.add(new ImportntLinkInfo("Renuka Ji"));
        touristPlacesList.add(new ImportntLinkInfo("Churdar Track"));
        touristPlacesList.add(new ImportntLinkInfo("Shivalik Fossil Park, Suketi "));
        touristPlacesList.add(new ImportntLinkInfo("Jaitak Fort"));

    }

}
