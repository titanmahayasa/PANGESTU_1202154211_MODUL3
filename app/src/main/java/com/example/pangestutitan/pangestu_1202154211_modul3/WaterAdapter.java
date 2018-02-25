package com.example.pangestutitan.pangestu_1202154211_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Pangestu Titan on 2/25/2018.
 */

class WaterAdapter extends RecyclerView.Adapter<WaterAdapter.WaterViewHolder>  {


    //Member variables
    private GradientDrawable mGradientDrawable;
    private ArrayList<Water> mWaterData;
    private Context mContext;





    /**
     * Constructor that passes in the sports data and the context
     * @param sportsData ArrayList containing the sports data
     * @param context Context of the application
     */
    WaterAdapter(Context context, ArrayList<Water> sportsData) {
        this.mWaterData = sportsData;
        this.mContext = context;

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.ades);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

    }


    /**
     * Required method for creating the viewholder objects.
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly create ViewHolder.
     */
    @Override
    public WaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WaterViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }
    @Override
    public void onBindViewHolder(WaterViewHolder holder, int position) {

        //Get the current sport
        Water currentWater = mWaterData.get(position);

        //Bind the data to the views
        holder.bindTo(currentWater);

    }

    /**
     * Required method for determining the size of the data set.
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mWaterData.size();
    }

    /**
     * SportsViewHolder class that represents each row of data in the RecyclerView
     */
    static class WaterViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mWaterImage;
        private Context mContext;
        private Water mCurrentWater;
        private GradientDrawable mGradientDrawable;


        /**
         * Constructor for the SportsViewHolder, used in onCreateViewHolder().
         * @param itemView The rootview of the list_item.xml layout file
         */
        WaterViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mWaterImage = (ImageView)itemView.findViewById(R.id.waterImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Water currentWater){
            //Populate the textviews with data
            mTitleText.setText(currentWater.getTitle());
            mInfoText.setText(currentWater.getInfo());

            //Get the current sport
            mCurrentWater = currentWater;



            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentWater.
                    getImageResource()).placeholder(mGradientDrawable).into(mWaterImage);
        }

        @Override
        public void onClick(View view) {

            //Set up the detail intent
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("title", mCurrentWater.getTitle());
            detailIntent.putExtra("image_resource", mCurrentWater.getImageResource());


            //Start the detail activity
            mContext.startActivity(detailIntent);
        }
    }
}



