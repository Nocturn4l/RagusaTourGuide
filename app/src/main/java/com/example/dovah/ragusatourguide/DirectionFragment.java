package com.example.dovah.ragusatourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class DirectionFragment extends Fragment {
    View rootView;
    private RecyclerView recyclerView;
    private List<Sight> sights;

    public DirectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sight_list, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), sights, 3);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Improve performance
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(4);
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


        sights.add(new Sight(getString( R.string.direction_name_1), getString(R.string.direction_description_1), getString(R.string.direction_site_1), R.drawable.piolatorre));
        sights.add(new Sight(getString( R.string.direction_name_2),  getString(R.string.direction_description_2), getString(R.string.direction_site_2),R.drawable.fontanarossa));
        sights.add(new Sight(getString( R.string.direction_name_3),  getString(R.string.direction_description_3),getString(R.string.direction_site_3), R.drawable.ast));
        sights.add(new Sight(getString( R.string.direction_name_4),  getString(R.string.direction_description_4),getString(R.string.direction_site_4), R.drawable.etna));


    }
}
