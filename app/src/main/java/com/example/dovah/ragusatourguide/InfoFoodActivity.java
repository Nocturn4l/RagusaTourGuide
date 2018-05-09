package com.example.dovah.ragusatourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class InfoFoodActivity extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.info_food_activity);


    // Get a support ActionBar corresponding to this toolbar and enable the Up button
    Toolbar infoToolbar = findViewById(R.id.toolbar);
    setSupportActionBar(infoToolbar);
    ActionBar ab = getSupportActionBar();
    // Enable the Up button
    ab.setDisplayHomeAsUpEnabled(true);

    //Retrieving Intent Data and Populate the Layout
    Intent incomeIntent = getIntent();
    TextView title=findViewById(R.id.title);
    TextView telephone=findViewById(R.id.number);
    TextView site=findViewById(R.id.site);
    TextView address=findViewById(R.id.address);
    title.setText(incomeIntent.getStringExtra("sight_name"));
    telephone.setText(incomeIntent.getStringExtra("sight_number"));
    site.setText(incomeIntent.getStringExtra("sight_site"));
    address.setText(incomeIntent.getStringExtra("sight_address"));
    ImageView photoSight=findViewById(R.id.photo);
    photoSight.setImageResource(incomeIntent.getIntExtra("sight_photo",0));

    //Add a ClickListener that call a map intent
    ImageView mapIcon=findViewById(R.id.map_ico);
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

    //Add a ClickListener that call a call intent
    ImageView telIcon=findViewById(R.id.number_ico);
    telIcon.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent callIntent=new Intent(Intent.ACTION_DIAL);
            TextView number=findViewById(R.id.number);
            String tel_number = (number.getText().toString());
            Uri call=Uri.parse("tel:"+tel_number);
            callIntent.setData(call);
            if (callIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(callIntent);
            }
        }
    });

    //Add a ClickListener that call a web intent
    ImageView webIcon=findViewById(R.id.web_ico);
    webIcon.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent webIntent=new Intent(Intent.ACTION_VIEW);
            TextView site=findViewById(R.id.site);
            String site_address = (site.getText().toString());
            Uri website=Uri.parse(site_address);
            webIntent.setData(website);
            if (webIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(webIntent);
            }
        }
    });

}
}