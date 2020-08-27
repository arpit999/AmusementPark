package com.bicubic.amusementpark.ride;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.fragment.ReviewDialogFragment;
import com.bicubic.amusementpark.model.RideDetails;
import com.bicubic.amusementpark.utils.ApiClient;
import com.bicubic.amusementpark.utils.ApiInterface;
import com.squareup.picasso.Picasso;
import com.whinc.widget.ratingbar.RatingBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RideDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = RideDetailActivity.class.getSimpleName();
    private View tv_photos, tv_videos, tv_review, tv_share;
    ApiInterface apiInterface;
    RideDetails rideDetails;
    RatingBar ratingBar;
    private ImageView img_header;
    private TextView tv_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_detail);

        ToolbarBack();

        FindIDs();

        final ProgressDialog pd = new ProgressDialog(RideDetailActivity.this);
        pd.setMessage("Please Wait...");
        pd.setCancelable(false);
        pd.show();

        Bundle bundle = getIntent().getExtras();

        String id = bundle.getString("id", "1");
        Log.i(TAG, "onCreate: id : " + id);

        if (!bundle.isEmpty()) {

            Call<RideDetails> globalCall = apiInterface.getRideDetails(id);

            globalCall.enqueue(new Callback<RideDetails>() {
                @Override
                public void onResponse(Call<RideDetails> call, Response<RideDetails> response) {

                    if (pd.isShowing()) {
                        pd.dismiss();
                    }

                    rideDetails = response.body();

                    Log.i(TAG, "onResponse: " + response.body());

                    if (rideDetails.getMessage().equals("success")) {

                        try {
                            Picasso.with(RideDetailActivity.this)
                                    .load(rideDetails.getRideImage())
                                    .error(R.drawable.placeholder)
                                    .error(R.drawable.placeholder)
                                    .fit()
                                    .into(img_header);

                            tv_desc.setText(rideDetails.getRideDesc());

                            ratingBar.setCount(Integer.parseInt(rideDetails.getRatting()));

                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                    }


                }

                @Override
                public void onFailure(Call<RideDetails> call, Throwable t) {

                    Log.e(TAG, "onFailure: "+t.toString());
                    if (pd.isShowing()) {
                        pd.dismiss();
                    }
                }
            });
        }

    }


    private void FindIDs() {

        tv_photos = findViewById(R.id.tv_photos);
        tv_videos = findViewById(R.id.tv_videos);
        tv_review = findViewById(R.id.tv_review);
        tv_share = findViewById(R.id.tv_share);

        img_header = (ImageView) findViewById(R.id.img_header);
        tv_desc = (TextView) findViewById(R.id.tv_desc);
        ratingBar = (com.whinc.widget.ratingbar.RatingBar) findViewById(R.id.ratingBar);


        MaterialRippleLayout.on(tv_photos)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        MaterialRippleLayout.on(tv_videos)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        MaterialRippleLayout.on(tv_review)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        MaterialRippleLayout.on(tv_share)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        tv_photos.setOnClickListener(this);
        tv_videos.setOnClickListener(this);
        tv_review.setOnClickListener(this);
        tv_share.setOnClickListener(this);

    }

    private void ToolbarBack() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("");
        TextView mTitle = (TextView) toolbar.findViewById(R.id.tv_toolbar_title);
        mTitle.setText("Ride Detail");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.tv_photos:

                if (rideDetails != null) {

                    Intent intent = new Intent(RideDetailActivity.this, RideImageGridActivity.class);
                    intent.putExtra("RideDetails", (Parcelable) rideDetails);
                    startActivity(intent);
                }

                break;

            case R.id.tv_videos:

                if (rideDetails != null) {

                    Intent intent = new Intent(RideDetailActivity.this, RideVideoGridActivity.class);
                    intent.putExtra("RideDetails", (Parcelable) rideDetails);
                    Log.i(TAG, "onClick: rideDetails : " + rideDetails);
                    startActivity(intent);
                }

                break;
            case R.id.tv_share:

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

                break;
            case R.id.tv_review:

                Bundle bundle1 = getIntent().getExtras();
                String id = bundle1.getString("id", "1");

                ReviewDialogFragment dialogFragment = new ReviewDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putString("rideid", id);
                dialogFragment.setArguments(bundle);
                dialogFragment.show((RideDetailActivity.this).getSupportFragmentManager(), "Rating Dialog");

                break;

            default:

                break;

        }


    }

}
