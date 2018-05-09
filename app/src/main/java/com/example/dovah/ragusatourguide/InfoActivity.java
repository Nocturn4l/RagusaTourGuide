package com.example.dovah.ragusatourguide;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);


        // Get a support ActionBar corresponding to this toolbar and enable the Up button
        Toolbar infoToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(infoToolbar);
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);


        //Retrieving Intent Data and Populate the Layout
        Intent incomeIntent = getIntent();
        TextView title=findViewById(R.id.title);
        TextView descr=findViewById(R.id.description);
        TextView address=findViewById(R.id.address);
        title.setText(incomeIntent.getStringExtra("sight_name"));
        descr.setText(incomeIntent.getStringExtra("sight_description"));
        address.setText(incomeIntent.getStringExtra("sight_address"));
        ImageView photoSight=findViewById(R.id.photo);
        photoSight.setImageResource(incomeIntent.getIntExtra("sight_photo",0));

        //Add a ClickListener that call a map intent
        ImageView mapIcon=findViewById(R.id.map);
        mapIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent=new Intent(Intent.ACTION_VIEW);
                TextView address=findViewById(R.id.address);
                String map_address = (address.getText().toString()).replaceAll(" ", "+");
                Uri geoLocation=Uri.parse("geo:0,0?q="+map_address);
                mapIntent.setData(geoLocation);
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

    }
}