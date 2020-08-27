package com.bicubic.amusementpark.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.adapter.RvGallerImageAdapter;
import com.bicubic.amusementpark.adapter.RvGallerVideoAdapter;
import com.bicubic.amusementpark.fragment.ImageViewDialogFragment;
import com.bicubic.amusementpark.model.Gallery;
import com.bicubic.amusementpark.utils.ApiClient;
import com.bicubic.amusementpark.utils.ApiInterface;
import com.bicubic.amusementpark.utils.RecyclerItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryReviewActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = GalleryReviewActivity.class.getSimpleName();
    RecyclerView rv_video;
    RecyclerView rv_image;
    View bt_video, bt_image;
    ApiInterface apiInterface;
    RelativeLayout rel_image,rel_video;
    List<Gallery.GalleryImageBean> galleryImageBeanList;
    List<Gallery.GalleryVideoBean> galleryVideoBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_review);

        rel_image = (RelativeLayout) findViewById(R.id.rel_image);
        rel_video = (RelativeLayout) findViewById(R.id.rel_video);
        rv_video = (RecyclerView) findViewById(R.id.rv_video);
        rv_image = (RecyclerView) findViewById(R.id.rv_image);
        bt_video =  findViewById(R.id.bt_video);
        bt_image = findViewById(R.id.bt_image);
        rel_video.setBackgroundResource(R.color.colorAccent);

        MaterialRippleLayout.on(bt_image)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        MaterialRippleLayout.on(bt_video)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        rel_image.setBackgroundResource(R.color.colorAccent);
        rel_video.setBackgroundResource(R.color.colorPrimary);
        rv_image.setVisibility(View.VISIBLE);
        rv_video.setVisibility(View.GONE);

        bt_video.setOnClickListener(this);
        bt_image.setOnClickListener(this);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(GalleryReviewActivity.this,3);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(GalleryReviewActivity.this);
        rv_video.setLayoutManager(layoutManager);
        rv_video.setHasFixedSize(true);

        RecyclerView.LayoutManager image_layoutManager = new GridLayoutManager(GalleryReviewActivity.this,3);
        rv_image.setLayoutManager(image_layoutManager );
        rv_image.setHasFixedSize(true);

        ToolbarBack();

        FetchData();

        rv_image.addOnItemTouchListener(
                new RecyclerItemClickListener(GalleryReviewActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click

                        if (galleryImageBeanList!=null && !galleryImageBeanList.isEmpty()) {
                            ImageViewDialogFragment dialogFragment = new ImageViewDialogFragment ();
                            Bundle bundle = new Bundle();
                            bundle.putString("link",galleryImageBeanList.get(position).getImage());
                            bundle.putString("name",galleryImageBeanList.get(position).getImage());
                            dialogFragment.setArguments(bundle);
                            dialogFragment.show((GalleryReviewActivity.this).getSupportFragmentManager(),"Image Dialog");
                        }

                    }
                })
        );


        rv_video.addOnItemTouchListener(
                new RecyclerItemClickListener(GalleryReviewActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click

                        if (galleryVideoBeanList!=null && !galleryVideoBeanList.isEmpty()) {
                            Intent intent = new Intent(GalleryReviewActivity.this,VideoViewActivity.class);
                            intent.putExtra("link",galleryVideoBeanList.get(position).getVideo());
                            intent.putExtra("name",galleryVideoBeanList.get(position).getVideo());
                            startActivity(intent);
                        }

                    }
                })
        );


    }

    private void FetchData() {

        final Call<Gallery> moviesCall = apiInterface.getGallery();
        moviesCall.enqueue(new Callback<Gallery>() {
            @Override
            public void onResponse(Call<Gallery> call, Response<Gallery> response) {

                Log.i(TAG, "onResponse: Call : " + call + " Response : " + response.body());
                Gallery gallery = response.body();

                galleryVideoBeanList = gallery.getGalleryVideo();
                galleryImageBeanList = gallery.getGalleryImage();

                RvGallerImageAdapter rvGallerImageAdapter = new RvGallerImageAdapter(galleryImageBeanList,GalleryReviewActivity.this);
                rv_image.setAdapter(rvGallerImageAdapter);

                RvGallerVideoAdapter rvGallerVideoAdapter = new RvGallerVideoAdapter(galleryVideoBeanList,GalleryReviewActivity.this);
                rv_video.setAdapter(rvGallerVideoAdapter);

            }

            @Override
            public void onFailure(Call<Gallery> call, Throwable t) {

                Log.e(TAG, "onFailure: error : " + t.toString());
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
        mTitle.setText("Gallery");

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

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

            case R.id.bt_image:

                rel_image.setBackgroundResource(R.color.colorAccent);
                rel_video.setBackgroundResource(R.color.colorPrimary);
                rv_image.setVisibility(View.VISIBLE);
                rv_video.setVisibility(View.GONE);

                if (galleryImageBeanList.isEmpty()) {
                    FetchData();
                }else {
                    RvGallerImageAdapter rvGallerImageAdapter = new RvGallerImageAdapter(galleryImageBeanList,GalleryReviewActivity.this);
                    rv_image.setAdapter(rvGallerImageAdapter);
                }


                break;

            case R.id.bt_video:

                rel_video.setBackgroundResource(R.color.colorAccent);
                rel_image.setBackgroundResource(R.color.colorPrimary);
                rv_video.setVisibility(View.VISIBLE);
                rv_image.setVisibility(View.GONE);

                if (galleryVideoBeanList.isEmpty()) {
                    FetchData();
                }else {
                    RvGallerVideoAdapter rvGallerVideoAdapter = new RvGallerVideoAdapter(galleryVideoBeanList,GalleryReviewActivity.this);
                    rv_video.setAdapter(rvGallerVideoAdapter);
                }

                break;

            default:

                break;


        }


    }
}
