package com.bicubic.amusementpark.fragment;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.model.Rating;
import com.bicubic.amusementpark.utils.ApiClient;
import com.bicubic.amusementpark.utils.ApiInterface;
import com.whinc.widget.ratingbar.RatingBar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by admin on 15-Nov-16.
 */

public class ReviewDialogFragment extends AppCompatDialogFragment implements View.OnClickListener {

    //    Button bt_submit;
    View rootView;
    ApiInterface apiInterface;
    private RatingBar ratingBar;
    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.review_dialogfragment, container, false);

        View tv_submit = rootView.findViewById(R.id.tv_submit);

        ratingBar = (RatingBar) rootView.findViewById(R.id.ratingBar);
        Toast.makeText(getActivity(), "" + ratingBar.getCount(), Toast.LENGTH_SHORT).show();
        MaterialRippleLayout.on(tv_submit)
                .rippleColor(Color.parseColor("#FF0000"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();

        tv_submit.setOnClickListener(this);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        bundle = getArguments();


        return rootView;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.tv_submit:

                String theme_type = "";
                String rideid = "";

                if (bundle != null) {

                    theme_type = bundle.getString("theme_type", "");
                    rideid = bundle.getString("rideid", "");

//                    Toast.makeText(getActivity(), "Theme Type : " + theme_type, Toast.LENGTH_SHORT).show();

                    SharedPreferences settings = getActivity().getSharedPreferences("preference", 0);
                    Call<Rating> ratingCall = apiInterface.setRating(settings.getString("userid", "1"), rideid, String.valueOf(ratingBar.getCount()), theme_type);

                    ratingCall.enqueue(new Callback<Rating>() {
                        @Override
                        public void onResponse(Call<Rating> call, Response<Rating> response) {

                            Rating rating = response.body();

                            Log.i(TAG, "onResponse: " + rating.getMessage());

                            if (rating.getMessage().equals("success")) {
                                getDialog().dismiss();
                            } else {
                                Toast.makeText(getActivity(), "" + rating.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<Rating> call, Throwable t) {

                        }
                    });

                } else {
                    Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }


                break;

            default:

                break;

        }

    }
}
