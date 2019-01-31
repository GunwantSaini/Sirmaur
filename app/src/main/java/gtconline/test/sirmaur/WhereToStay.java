package gtconline.test.sirmaur;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import gtconline.test.sirmaur.Ui.Fragments.HotelsandGuestHouses;

public class WhereToStay extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager whereToStayViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where_to_stay);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        whereToStayViewPager=findViewById(R.id.whereToStayViewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(whereToStayViewPager);

        setViewPager();

    }

    public void setViewPager()
    {


        WhereToStay.ViewPagerAdapter adapter = new WhereToStay.ViewPagerAdapter(getSupportFragmentManager());
     //   adapter.addFragment(new HowToReachByAir(), "By Air");
        adapter.addFragment(new HotelsandGuestHouses(), "Hotels and Guest Houses");
        whereToStayViewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }




}
