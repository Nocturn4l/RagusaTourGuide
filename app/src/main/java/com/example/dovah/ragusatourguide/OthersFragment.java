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


public class OthersFragment extends Fragment {
    View rootView;
    private RecyclerView recyclerView;
    private List<Sight> sights;

    public OthersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sight_list, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), sights, 1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //Add a divider
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));
        //Improve performance
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(7);
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

        sights.add(new Sight(getString(R.string.others_name_1), getString(R.string.others_description_1), getString(R.string.others_address_1), R.drawable.parezzo));
        sights.add(new Sight(getString(R.string.others_name_2), getString(R.string.others_description_2), getString(R.string.others_address_2), R.drawable.circolo));
        sights.add(new Sight(getString(R.string.others_name_3), getString(R.string.others_description_3), getString(R.string.others_address_3), R.drawable.giardini));
        sights.add(new Sight(getString(R.string.others_name_4), getString(R.string.others_description_4), getString(R.string.others_address_4), R.drawable.castello));
        sights.add(new Sight(getString(R.string.others_name_5), getString(R.string.others_description_5), getString(R.string.others_address_5), R.drawable.museoibleo));
        sights.add(new Sight(getString(R.string.others_name_6), getString(R.string.others_description_6), getString(R.string.others_address_6), R.drawable.sgiacomo));
        sights.add(new Sight(getString(R.string.others_name_7), getString(R.string.others_description_7), getString(R.string.others_address_7), R.drawable.sagata));

    }

}