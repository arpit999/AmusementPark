package com.bicubic.amusementpark.activity;

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
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.fragment.ReviewDialogFragment;
import com.bicubic.amusementpark.model.Global;
import com.bicubic.amusementpark.utils.ApiClient;
import com.bicubic.amusementpark.utils.ApiInterface;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodBeveragesActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = FoodBeveragesActivity.class.getSimpleName();
    View tv_photos, tv_videos, tv_review, tv_share;
    ImageView img_header;
    TextView tv_desc;
    private com.whinc.widget.ratingbar.RatingBar ratingBar;

    //    MaterialRippleLayout ripple_photos;
    ApiInterface apiInterface;
    Global global;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_beverages);
        ToolbarBack();

        FindIDs();

        final ProgressDialog pd = new ProgressDialog(FoodBeveragesActivity.this);
        pd.setMessage("Please Wait...");
        pd.setCancelable(false);
        pd.show();

        Call<Global> globalCall = apiInterface.getRestaurantVlaue();

        globalCall.enqueue(new Callback<Global>() {
            @Override
            public void onResponse(Call<Global> call, Response<Global> response) {

                if (pd.isShowing()) {
                    pd.dismiss();
                }

                Log.d(TAG, "onResponse() called with: call = [" + call + "], response = [" + response + "]");

                global = new Global();
                global = response.body();
//                List<Global.ImageBean> imageBeanList = global.getImage();
//                List<Global.VideoBean> videoBeanList = global.getVideo();

                Log.i(TAG, "onResponse: imageList : " + global.toString());

                if (global.getMessage().equals("success")) {

                    try {
                        Picasso.with(FoodBeveragesActivity.this)
                                .load(global.getRestaurantImage())
                                .error(R.drawable.placeholder)
                                .error(R.drawable.placeholder)
                                .fit()
                                .into(img_header);

                        tv_desc.setText(global.getDescription());

                        ratingBar.setCount(Integer.parseInt(global.getRatting()));

                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(FoodBeveragesActivity.this, "" + global.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Global> call, Throwable t) {

                Log.e(TAG, "onFailure: " + t.toString());
                if (pd.isShowing()) {
                    pd.dismiss();
                }

            }
        });


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
        mTitle.setText("Food");

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

                if (global != null) {

                    Intent intent = new Intent(FoodBeveragesActivity.this, ImageGridActivity.class);
                    intent.putExtra("global", (Parcelable) global);
                    startActivity(intent);
                }

                break;

            case R.id.tv_videos:

                if (global != null) {

                    Intent intent = new Intent(FoodBeveragesActivity.this, VideoGridActivity.class);
                    intent.putExtra("global", (Parcelable) global);
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
                ReviewDialogFragment dialogFragment = new ReviewDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putString("theme_type","2");
                dialogFragment.setArguments(bundle);
                dialogFragment.show((FoodBeveragesActivity.this).getSupportFragmentManager(), "Rating Dialog");
                break;

            default:

                break;

        }


    }
}
