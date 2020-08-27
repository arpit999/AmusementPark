package com.bicubic.amusementpark.ride;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.adapter.RvRideImageAdapter;
import com.bicubic.amusementpark.fragment.ImageViewDialogFragment;
import com.bicubic.amusementpark.model.RideDetails;
import com.bicubic.amusementpark.utils.RecyclerItemClickListener;

import java.util.List;

public class RideImageGridActivity extends AppCompatActivity {

    private static final String TAG = RideImageGridActivity.class.getSimpleName();

    RecyclerView rv_image;
    List<RideDetails.ImageBean> imageBeanList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);
        rv_image = (RecyclerView) findViewById(R.id.recyclerView);
        ToolbarBack();

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(RideImageGridActivity.this,2);
        rv_image.setLayoutManager(layoutManager);
        rv_image.setHasFixedSize(true);

        Intent i = getIntent();
        if (i!=null) {
            RideDetails rideDetails = (RideDetails) i.getParcelableExtra("RideDetails");
            imageBeanList = rideDetails.getImage();
            Log.i(TAG, "onCreate: imagelist : "+imageBeanList);

            RvRideImageAdapter rvRestImageAdapter = new RvRideImageAdapter(imageBeanList,RideImageGridActivity.this);
            rv_image.setAdapter(rvRestImageAdapter);
        }else {

            Toast.makeText(RideImageGridActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }


        rv_image.addOnItemTouchListener(
                new RecyclerItemClickListener(RideImageGridActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click

                        ImageViewDialogFragment dialogFragment = new ImageViewDialogFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("link",imageBeanList.get(position).getRideImage());
//                        bundle.putString("name",videoBeanList.get(position).get);
                        dialogFragment.setArguments(bundle);
                        dialogFragment.show((RideImageGridActivity.this).getSupportFragmentManager(),"Image Dialog");

                    }
                })
        );


    }


    private void ToolbarBack() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("");
        TextView mTitle = (TextView) toolbar.findViewById(R.id.tv_toolbar_title);
        mTitle.setText("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
