package com.parthhingorani.gyrfalcon.Offers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.parthhingorani.gyrfalcon.GlideApp;
import com.parthhingorani.gyrfalcon.R;

import java.util.List;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.MyViewHolder> {

    //data structures
    private List<Offer> offersList;
    static Context context;

    //constructor
    public OffersAdapter(Context context, List<Offer> offersList){
        OffersAdapter.context = context;
        this.offersList = offersList;
    }

    //object holder
    @Override
    public OffersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_offers, parent, false);
        OffersAdapter.MyViewHolder holder = new OffersAdapter.MyViewHolder(view);
        return holder;
    }

    //set object data
    @Override
    public void onBindViewHolder(OffersAdapter.MyViewHolder holder, int position) {
        holder.setData(offersList.get(position));
    }

    //returns total offers count
    @Override
    public int getItemCount() {
        return offersList.size();
    }

    //inner viewholder class
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        //data structures
        ImageView ivOfferImage;
        TextView tvOfferTitle, tvOfferDescription;

        //initialize structures
        private MyViewHolder(View itemView) {
            super(itemView);

            ivOfferImage = itemView.findViewById(R.id.ivOffer);
            tvOfferTitle = itemView.findViewById(R.id.tvOfferTitle);
            tvOfferDescription = itemView.findViewById(R.id.tvOfferDescription);
        }

        //set data in placeholders
        public void setData(final Offer data){

            tvOfferTitle.setText(data.offerTitle);
            tvOfferDescription.setText(data.offerDescription);

            GlideApp.with(context)
                    .load(data.offerURL)
                    .fitCenter()
                    .into(ivOfferImage);
        }
    }
}
