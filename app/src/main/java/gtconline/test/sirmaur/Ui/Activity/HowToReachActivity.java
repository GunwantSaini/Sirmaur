package gtconline.test.sirmaur.Ui.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import gtconline.test.sirmaur.Adapter.ViewPagerAdapter;
import gtconline.test.sirmaur.R;
import gtconline.test.sirmaur.Ui.Fragments.HowToRachByTrain;
import gtconline.test.sirmaur.Ui.Fragments.HowToReachByAir;
import gtconline.test.sirmaur.Ui.Fragments.howToReachByRoad;

public class HowToReachActivity extends AppCompatActivity {

    ViewPager howToReachViewPager;

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_reach);

         howToReachViewPager=findViewById(R.id.howToReachViewPager);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(howToReachViewPager);

         setViewPager();

    }
    public void setViewPager()
    {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HowToReachByAir(), "By Air");
        adapter.addFragment(new HowToRachByTrain(), "By Train");
        adapter.addFragment(new howToReachByRoad(), "By Road");
        howToReachViewPager.setAdapter(adapter);
    }






    }
