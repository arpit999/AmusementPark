package com.bicubic.amusementpark.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.model.Gallery;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by admin on 15-Nov-16.
 */

public class RvGallerImageAdapter extends RecyclerView.Adapter<RvGallerImageAdapter.ImageHolder> {

    List<Gallery.GalleryImageBean> galleryImageBeanList;
    static Context context;

    public RvGallerImageAdapter(List<Gallery.GalleryImageBean> galleryImageBeanList, Context context) {
        this.galleryImageBeanList = galleryImageBeanList;
        RvGallerImageAdapter.context = context;
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_row, parent, false);
        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageHolder holder, int position) {

        Picasso.with(context)
                .load(galleryImageBeanList.get(position).getImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return galleryImageBeanList.size();
    }

    static class ImageHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public ImageHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.img_gallery);

        }

    }


}
