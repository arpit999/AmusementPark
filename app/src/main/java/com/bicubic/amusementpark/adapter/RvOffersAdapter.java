package com.bicubic.amusementpark.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bicubic.amusementpark.R;
import com.bicubic.amusementpark.model.Offers;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by admin on 17-Nov-16.
 */

public class RvOffersAdapter extends RecyclerView.Adapter<RvOffersAdapter.OfferHolder> {

    Context context;
    List<Offers.DataBean> offerList;

    public RvOffersAdapter(Context context, List<Offers.DataBean> offerList) {
        this.context = context;
        this.offerList = offerList;
    }

    @Override
    public OfferHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_row, parent, false);

        return new OfferHolder(view);
    }

    @Override
    public void onBindViewHolder(OfferHolder holder, int position) {

        holder.tv_offer_title.setText(offerList.get(position).getTitle());
//        holder.ratingBar.setRating(Float.parseFloat(offerList.get(position).getRatting()));

        Picasso.with(context)
                .load(offerList.get(position).getImage())
                .fit()
                .into(holder.img_offer);

    }

    @Override
    public int getItemCount() {
        return offerList.size();
    }

    public class OfferHolder extends RecyclerView.ViewHolder {

        ImageView img_offer;
        TextView tv_offer_title;

        public OfferHolder(View itemView) {
            super(itemView);

            img_offer = (ImageView) itemView.findViewById(R.id.img_offers);
            tv_offer_title = (TextView) itemView.findViewById(R.id.tv_offer_title);

        }

    }


}
