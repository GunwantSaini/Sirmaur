package gtconline.test.sirmaur.Ui.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gtconline.test.sirmaur.Adapter.ViewPagerAdapter;
import gtconline.test.sirmaur.R;
import gtconline.test.sirmaur.Ui.Fragments.HowToRachByTrain;
import gtconline.test.sirmaur.Ui.Fragments.HowToReachByAir;
import gtconline.test.sirmaur.Ui.Fragments.ReligiousPlaces;
import gtconline.test.sirmaur.Ui.Fragments.TouristPlaces;
import gtconline.test.sirmaur.Ui.Fragments.howToReachByRoad;

public class Excursions extends AppCompatActivity {

    ViewPager excursionsViewPager;

    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursions);


        excursionsViewPager=findViewById(R.id.excursionsViewPager);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(excursionsViewPager);

        setViewPager();


    }


    public void setViewPager()
    {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ReligiousPlaces(), "Religious/Historical Places");
        adapter.addFragment(new TouristPlaces(), "Tourist/Others");
        excursionsViewPager.setAdapter(adapter);
    }

}
