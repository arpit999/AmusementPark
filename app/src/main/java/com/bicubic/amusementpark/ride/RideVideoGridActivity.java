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
import com.bicubic.amusementpark.activity.VideoViewActivity;
import com.bicubic.amusementpark.adapter.RvRideVideoAdapter;
import com.bicubic.amusementpark.model.RideDetails;
import com.bicubic.amusementpark.utils.ApiClient;
import com.bicubic.amusementpark.utils.ApiInterface;
import com.bicubic.amusementpark.utils.RecyclerItemClickListener;

import java.util.List;

public class RideVideoGridActivity extends AppCompatActivity {

    private static final String TAG = RideVideoGridActivity.class.getSimpleName();

//    int[] ridesList = new int[]{R.drawable.ride_one, R.drawable.ride_two, R.drawable.ride_three, R.drawable.ride_four, R.drawable.ride_five, R.drawable.ride_six, R.drawable.ride_seven, R.drawable.ride_eight, R.drawable.ride_nine, R.drawable.ride_ten, R.drawable.ride_eleven, R.drawable.ride_twelve, R.drawable.ride_thirteen, R.drawable.ride_fourteen, R.drawable.ride_fifteen, R.drawable.ride_sixteen, R.drawable.ride_eighteen};

    ApiInterface apiInterface;
    RecyclerView rv_ride_video;
    List<RideDetails.VideoBean> videoBeanList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ride_video_grid);
        rv_ride_video = (RecyclerView) findViewById(R.id.rv_ride_video);
        ToolbarBack();

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(RideVideoGridActivity.this, 2);
        rv_ride_video.setLayoutManager(layoutManager);
        rv_ride_video.setHasFixedSize(true);

        Intent i = getIntent();
        if (i != null) {
            RideDetails rideDetails = (RideDetails) i.getParcelableExtra("RideDetails");
            videoBeanList = rideDetails.getVideo();
            Log.i(TAG, "onCreate: imagelist : " + videoBeanList);

            RvRideVideoAdapter rvRestImageAdapter = new RvRideVideoAdapter(videoBeanList, RideVideoGridActivity.this);
            rv_ride_video.setAdapter(rvRestImageAdapter);
        } else {

            Toast.makeText(RideVideoGridActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }


        rv_ride_video.addOnItemTouchListener(
                new RecyclerItemClickListener(RideVideoGridActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click

                        if (!videoBeanList.isEmpty()) {
                            Intent intent = new Intent(RideVideoGridActivity.this,VideoViewActivity.class);
                            intent.putExtra("link",videoBeanList.get(position).getRideVideo());
                            intent.putExtra("name",videoBeanList.get(position).getRideVideo());
                            startActivity(intent);
                        }

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
        mTitle.setText("Ride Viedos");

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
