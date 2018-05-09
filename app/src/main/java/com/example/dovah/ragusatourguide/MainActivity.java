package com.example.dovah.ragusatourguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        viewPager =  findViewById(R.id.viewpager);
        // Find the tab layout that shows the tabs
        tabLayout =  findViewById(R.id.tabs);

        // Create an adapter that knows which fragment should be shown on each page
        adapter = new ViewPagerAdapter( getSupportFragmentManager());

        //Add Fragments
        adapter.addFragment(new UNESCOFragment(), getString(R.string.fragment_title_1));
        adapter.addFragment(new OthersFragment(), getString(R.string.fragment_title_2));
        adapter.addFragment(new FoodFragment(), getString(R.string.fragment_title_3));
        adapter.addFragment(new DirectionFragment(), getString(R.string.fragment_title_4));

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
