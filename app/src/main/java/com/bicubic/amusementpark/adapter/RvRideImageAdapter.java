package com.bicubic.amusementpark.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.model.RideDetails;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by admin on 18-Nov-16.
 */

public class RvRideImageAdapter extends RecyclerView.Adapter<RvRideImageAdapter.ImageHolder> {

    List<RideDetails.ImageBean> imageBeanList;
    Context context;

    public RvRideImageAdapter(List<RideDetails.ImageBean> imageBeanList, Context context) {
        this.imageBeanList = imageBeanList;
        this.context = context;
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_row, parent, false);
        return new ImageHolder(view);

    }

    @Override
    public void onBindViewHolder(ImageHolder holder, int position) {

        Picasso.with(context)
                .load(imageBeanList.get(position).getRideImage())
                .fit()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return imageBeanList.size();
    }

    public static class ImageHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ImageHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.img_gallery);

        }

    }


}
