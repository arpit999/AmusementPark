package com.bicubic.amusementpark.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.adapter.RvOffersAdapter;
import com.bicubic.amusementpark.fragment.ImageViewDialogFragment;
import com.bicubic.amusementpark.model.Offers;
import com.bicubic.amusementpark.utils.ApiClient;
import com.bicubic.amusementpark.utils.ApiInterface;
import com.bicubic.amusementpark.utils.RecyclerItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotOffersActivity extends AppCompatActivity {

    private static final String TAG = HotOffersActivity.class.getSimpleName();
    ApiInterface apiInterface;
    RecyclerView rv_offer;
    List<Offers.DataBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_offers);

        ToolbarBack();

        FindIDs();

        Call<Offers> offersCall = apiInterface.getAllOffers();

        offersCall.enqueue(new Callback<Offers>() {
            @Override
            public void onResponse(Call<Offers> call, Response<Offers> response) {

                Offers offers = response.body();

                list = offers.getData();

                if (!list.isEmpty()) {
                    RvOffersAdapter rvOffersAdapter = new RvOffersAdapter(HotOffersActivity.this, list);
                    rv_offer.setAdapter(rvOffersAdapter);
                } else {
                    Toast.makeText(HotOffersActivity.this, "Data not found", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<Offers> call, Throwable t) {

                Log.e(TAG, "onFailure: " + t.toString());

            }
        });

        rv_offer.addOnItemTouchListener(
                new RecyclerItemClickListener(HotOffersActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click

                        if (!list.isEmpty()) {
                            ImageViewDialogFragment dialogFragment = new ImageViewDialogFragment ();
                            Bundle bundle = new Bundle();
                            bundle.putString("link",list.get(position).getImage());
                            bundle.putString("name",list.get(position).getTitle());
                            dialogFragment.setArguments(bundle);
                            dialogFragment.show((HotOffersActivity.this).getSupportFragmentManager(),"Image Dialog");
                        }else {
                            Toast.makeText(HotOffersActivity.this, "Data not found", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
        );

    }

    private void FindIDs() {

        rv_offer = (RecyclerView) findViewById(R.id.rv_offer);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        rv_offer.setLayoutManager(new LinearLayoutManager(HotOffersActivity.this));
    }

    private void ToolbarBack() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("");
        TextView mTitle = (TextView) toolbar.findViewById(R.id.tv_toolbar_title);
        mTitle.setText("Offers");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
