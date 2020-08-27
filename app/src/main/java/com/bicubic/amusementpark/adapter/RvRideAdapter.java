package com.bicubic.amusementpark.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.model.Ride;
import com.squareup.picasso.Picasso;
import com.whinc.widget.ratingbar.RatingBar;

import java.util.List;

/**
 * Created by admin on 17-Nov-16.
 */

public class RvRideAdapter extends RecyclerView.Adapter<RvRideAdapter.RideHolder> {

    Context context;
    List<Ride.DataBean> rideList;


    public RvRideAdapter(Context context, List<Ride.DataBean> rideList) {
        this.context = context;
        this.rideList = rideList;
    }

    @Override
    public RideHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ride_row, parent, false);

        return new RideHolder(view);
    }

    @Override
    public void onBindViewHolder(RideHolder holder, int position) {

        holder.tv_name.setText(rideList.get(position).getName());
//        holder.ratingBar.setRating(Float.parseFloat(offerList.get(position).getRatting()));

        Picasso.with(context)
                .load(rideList.get(position).getImage())
                .fit()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return rideList.size();
    }

    public class RideHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tv_name;
        RatingBar ratingBar;

        public RideHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_title);
            ratingBar = (RatingBar) itemView.findViewById(R.id.rating);

        }

    }


}
