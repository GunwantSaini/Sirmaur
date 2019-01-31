package gtconline.test.sirmaur.Ui.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import gtconline.test.sirmaur.Adapter.ImportantLinkAdapter;
import gtconline.test.sirmaur.Pojo.ImportntLinkInfo;
import gtconline.test.sirmaur.R;
import gtconline.test.sirmaur.RecyclerItemClickHandler;

public class WhereToStayPlaceList extends AppCompatActivity {

    RecyclerView placesView;
    ArrayList<ImportntLinkInfo> placesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_to_stay_place_list);

        placesView=findViewById(R.id.placesListRv);

        placesList=new ArrayList<>();


        fillPlacesList();

        placesView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        placesView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        placesView.setAdapter(new ImportantLinkAdapter(placesList,this));


    }

    public void fillPlacesList()
    {
        String placeName=getIntent().getStringExtra("placeName");

        if(placeName.equals("Nahan"))
        {
            placesList.add(new ImportntLinkInfo("Rememberance Restaurant and Guest House opp. PWD RestHouse,Nahan"));
            placesList.add(new ImportntLinkInfo("Heritage Sanyam and Restaurant Ekant,Pacha Tank,Nahan"));
            placesList.add(new ImportntLinkInfo("Hotel Regency, opp. State Bank,The Mall,Nahan"));
            placesList.add(new ImportntLinkInfo("Hotel City Heart Near Chewgan,Nahan"));

        }
        else if (placeName.equals("Poanta Sahib")){

            placesList.add(new ImportntLinkInfo("Hotel RockWoo,near Y-Point, Poanta Sahib"));
            placesList.add(new ImportntLinkInfo("Hotel Grand Riveria Near Batapul,Poanta Sahib"));
            placesList.add(new ImportntLinkInfo("The Yamuna Hotel,Near Poanta Gurudwara,Poanta Sahib"));
        }



    }


}
