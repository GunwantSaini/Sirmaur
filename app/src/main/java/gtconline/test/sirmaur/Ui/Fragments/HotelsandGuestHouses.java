package gtconline.test.sirmaur.Ui.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import gtconline.test.sirmaur.Adapter.GridAdapter;
import gtconline.test.sirmaur.R;
import gtconline.test.sirmaur.Ui.Activity.WhereToStayPlaceList;
import gtconline.test.sirmaur.WhereToStay;


public class HotelsandGuestHouses extends Fragment {


    GridView hotelsView;
    ArrayList<String> hotelsList;

    public HotelsandGuestHouses() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_hotelsand_guest_houses, container, false);

        hotelsList=new ArrayList<>();
        hotelsView=view.findViewById(R.id.hotelsView);

        fillHotelsList();



     //   hotelsView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
      //  hotelsView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));



        hotelsView.setAdapter(( new GridAdapter(getActivity(),hotelsList)));




        hotelsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getActivity().startActivity(new Intent(getActivity(),WhereToStayPlaceList.class).putExtra("placeName",hotelsList.get(position)));

            }
        }
        );

        return view;

    }

    public void fillHotelsList()
    {
        hotelsList.add("Nahan");

        hotelsList.add("Poanta Sahib");

        hotelsList.add("Nahan");

        hotelsList.add("Poanta Sahib");



    }



}
