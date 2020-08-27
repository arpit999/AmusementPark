package com.bicubic.amusementpark.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.adapter.RvRideAdapter;
import com.bicubic.amusementpark.model.Ride;
import com.bicubic.amusementpark.utils.ApiClient;
import com.bicubic.amusementpark.utils.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AmazingRidesActivity extends AppCompatActivity {

    private static final String TAG = AmazingRidesActivity.class.getSimpleName();
    ApiInterface apiInterface;
    RecyclerView rv_rides;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazing_rides);

        rv_rides = (RecyclerView) findViewById(R.id.rv_rides);

        ToolbarBack();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AmazingRidesActivity.this);
        rv_rides.setLayoutManager(linearLayoutManager);
        rv_rides.setHasFixedSize(true);

        FetchRides();
    }

    private void FetchRides() {

        Call<Ride> listCall = apiInterface.getRides();
        listCall.enqueue(new Callback<Ride>() {
            @Override
            public void onResponse(Call<Ride> call, Response<Ride> response) {

                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");

                Ride ride = response.body();
                List<Ride.DataBean> dataBeanList = ride.getData();
                Log.i(TAG, "onResponse: response : " + ride.getMessage());
                RvRideAdapter rvRideAdapter = new RvRideAdapter(AmazingRidesActivity.this,dataBeanList);
                rv_rides.setAdapter(rvRideAdapter);

            }

            @Override
            public void onFailure(Call<Ride> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });

    }

    private void ToolbarBack() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("");
        TextView mTitle = (TextView) toolbar.findViewById(R.id.tv_toolbar_title);
        mTitle.setText("Rides");

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
