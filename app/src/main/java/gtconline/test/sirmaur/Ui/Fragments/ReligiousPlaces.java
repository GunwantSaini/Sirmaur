package gtconline.test.sirmaur.Ui.Fragments;

import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import gtconline.test.sirmaur.Adapter.ImportantLinkAdapter;
import gtconline.test.sirmaur.Pojo.ImportntLinkInfo;
import gtconline.test.sirmaur.R;
import gtconline.test.sirmaur.RecyclerItemClickHandler;
import gtconline.test.sirmaur.Ui.Activity.PlaceDetails;


public class ReligiousPlaces extends Fragment {

    RecyclerView religiousPlacesLv;
    ArrayList<ImportntLinkInfo> religiousPlacesList;

    public ReligiousPlaces() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_religious_places, container, false);

        religiousPlacesList=new ArrayList<>();

        fillReligiousPlaces();

        religiousPlacesLv=view.findViewById(R.id.religiousPlacesView);

        religiousPlacesLv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        religiousPlacesLv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        religiousPlacesLv.setAdapter(new ImportantLinkAdapter(religiousPlacesList,getActivity()));


        RecyclerItemClickHandler.addTo(religiousPlacesLv).setOnItemClickListener(new RecyclerItemClickHandler.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                getActivity().startActivity(new Intent(getContext(),PlaceDetails.class).putExtra("placeName",religiousPlacesList.get(position).getLinkName()));

            }
        });
        return view;
    }


    public void fillReligiousPlaces()
    {
        religiousPlacesList.add(new ImportntLinkInfo("Mahamaya Balasundari Temple, Trilokpur"));
        religiousPlacesList.add(new ImportntLinkInfo("Gurudwara Paonta Sahib"));
        religiousPlacesList.add(new ImportntLinkInfo("Paudiwala - Sawarg ki dusri sidhi Temple, Sainwala, Nahan"));
        religiousPlacesList.add(new ImportntLinkInfo("Shri Renuka Ji Temple, Renuka Ji"));
        religiousPlacesList.add(new ImportntLinkInfo("Maa Bhangayani Temple, Haripurdhar"));
        religiousPlacesList.add(new ImportntLinkInfo("Chudeshwar Temple Churdhar, Nohradhar"));
        religiousPlacesList.add(new ImportntLinkInfo("Bhureshwar Mahadev Temple, Nainatikker"));

    }

}
