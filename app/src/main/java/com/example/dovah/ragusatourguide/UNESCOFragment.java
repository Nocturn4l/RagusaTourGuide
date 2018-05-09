package com.example.dovah.ragusatourguide;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class UNESCOFragment extends Fragment {
    View rootView;
    private RecyclerView recyclerView;
    private List<Sight> sights;

    public UNESCOFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sight_list, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), sights, 0);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //Add a divider
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));
        //Improve performance
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(11);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        recyclerView.setAdapter(recyclerViewAdapter);
        return rootView;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Create a list of sights
        sights = new ArrayList<>();

        sights.add(new Sight(getString(R.string.unesco_name_1), getString(R.string.unesco_description_1), getString(R.string.unesco_address_1), R.drawable.sgiovanni));
        sights.add(new Sight(getString(R.string.unesco_name_2), getString(R.string.unesco_description_2), getString(R.string.unesco_address_2), R.drawable.pvescovile));
        sights.add(new Sight(getString(R.string.unesco_name_3), getString(R.string.unesco_description_3), getString(R.string.unesco_address_3), R.drawable.pzacco));
        sights.add(new Sight(getString(R.string.unesco_name_4), getString(R.string.unesco_description_4), getString(R.string.unesco_address_4), R.drawable.pbertini));
        sights.add(new Sight(getString(R.string.unesco_name_5), getString(R.string.unesco_description_5), getString(R.string.unesco_address_5), R.drawable.smaria));
        sights.add(new Sight(getString(R.string.unesco_name_6), getString(R.string.unesco_description_6), getString(R.string.unesco_address_6), R.drawable.itria));
        sights.add(new Sight(getString(R.string.unesco_name_7), getString(R.string.unesco_description_7), getString(R.string.unesco_address_7), R.drawable.pcosentini));
        sights.add(new Sight(getString(R.string.unesco_name_8), getString(R.string.unesco_description_8), getString(R.string.unesco_address_8), R.drawable.purgatorio));
        sights.add(new Sight(getString(R.string.unesco_name_9), getString(R.string.unesco_description_9), getString(R.string.unesco_address_9), R.drawable.filipponeri));
        sights.add(new Sight(getString(R.string.unesco_name_10), getString(R.string.unesco_description_10), getString(R.string.unesco_address_10), R.drawable.sgiorgio));
        sights.add(new Sight(getString(R.string.unesco_name_11), getString(R.string.unesco_description_11), getString(R.string.unesco_address_11), R.drawable.immacolata));

    }

}
