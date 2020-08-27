package com.bicubic.amusementpark.activity;

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
import com.bicubic.amusementpark.adapter.RvRestImageAdapter;
import com.bicubic.amusementpark.fragment.ImageViewDialogFragment;
import com.bicubic.amusementpark.model.Global;
import com.bicubic.amusementpark.utils.ApiClient;
import com.bicubic.amusementpark.utils.ApiInterface;
import com.bicubic.amusementpark.utils.RecyclerItemClickListener;

import java.util.List;

public class ImageGridActivity extends AppCompatActivity {

    private static final String TAG = ImageGridActivity.class.getSimpleName();

//    int[] ridesList = new int[]{R.drawable.ride_one, R.drawable.ride_two, R.drawable.ride_three, R.drawable.ride_four, R.drawable.ride_five, R.drawable.ride_six, R.drawable.ride_seven, R.drawable.ride_eight, R.drawable.ride_nine, R.drawable.ride_ten, R.drawable.ride_eleven, R.drawable.ride_twelve, R.drawable.ride_thirteen, R.drawable.ride_fourteen, R.drawable.ride_fifteen, R.drawable.ride_sixteen, R.drawable.ride_eighteen};

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    List<Global.ImageBean> imageBeanList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ToolbarBack();

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(ImageGridActivity.this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Intent i = getIntent();
        if (i!=null) {
            Global global = (Global)i.getParcelableExtra("global");
            imageBeanList = global.getImage();
            Log.i(TAG, "onCreate: imagelist : "+imageBeanList);

            RvRestImageAdapter rvRestImageAdapter = new RvRestImageAdapter(imageBeanList,ImageGridActivity.this);
            recyclerView.setAdapter(rvRestImageAdapter);
        }else {

            Toast.makeText(ImageGridActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(ImageGridActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click

                        ImageViewDialogFragment dialogFragment = new ImageViewDialogFragment ();
                        Bundle bundle = new Bundle();
                        bundle.putString("link",imageBeanList.get(position).getImage());
                        bundle.putString("name",imageBeanList.get(position).getImage());
                        dialogFragment.setArguments(bundle);
                        dialogFragment.show((ImageGridActivity.this).getSupportFragmentManager(),"Image Dialog");

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

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
