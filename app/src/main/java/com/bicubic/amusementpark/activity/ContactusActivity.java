package com.bicubic.amusementpark.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bicubic.amusementpark.R;

public class ContactusActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView img_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        ToolbarBack();

        img_map = (ImageView) findViewById(R.id.img_map);

        img_map.setOnClickListener(this);

    }

    private void ToolbarBack() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("");
        TextView mTitle = (TextView) toolbar.findViewById(R.id.tv_toolbar_title);
        mTitle.setText("Contact Us");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void AddressClick(View view) {
        showMap();
    }


    public void showMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("google.streetview:cbll=22.395516,70.643351&cbp=1,yaw,,-90,zoom&mz=2.0"));
        intent.setData(Uri.parse("geo:0,0?q=The+Eldorado+Park,+Rampar+Mota,+Gujarat,+India"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.img_map){
            showMap();
        }
    }
}
