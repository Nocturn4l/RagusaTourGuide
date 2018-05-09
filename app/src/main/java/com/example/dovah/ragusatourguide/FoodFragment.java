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


public class FoodFragment extends Fragment {
    View rootView;
    private RecyclerView recyclerView;
    private List<Sight> sights;

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sight_list, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), sights, 2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //Add a divider
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));
        //Improve performance
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(6);
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

        sights.add(new Sight(getString(R.string.food_name_1), getString(R.string.food_number_1), getString(R.string.food_sito_1), getString(R.string.food_address_1), R.drawable.capinera));
        sights.add(new Sight(getString(R.string.food_name_2), getString(R.string.food_number_1), getString(R.string.food_sito_2), getString(R.string.food_address_2), R.drawable.suri));
        sights.add(new Sight(getString(R.string.food_name_3), getString(R.string.food_number_2), getString(R.string.food_sito_3), getString(R.string.food_address_3), R.drawable.salumeria));
        sights.add(new Sight(getString(R.string.food_name_4), getString(R.string.food_number_3), getString(R.string.food_sito_4), getString(R.string.food_address_4), R.drawable.sicils));
        sights.add(new Sight(getString(R.string.food_name_5), getString(R.string.food_number_4), getString(R.string.food_sito_5), getString(R.string.food_address_5), R.drawable.delicatessen));
        sights.add(new Sight(getString(R.string.food_name_6), getString(R.string.food_number_5), getString(R.string.food_sito_6), getString(R.string.food_address_6), R.drawable.losteri));
    }

}
