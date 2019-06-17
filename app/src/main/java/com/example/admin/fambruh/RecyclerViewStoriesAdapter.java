package com.example.admin.fambruh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewStoriesAdapter extends RecyclerView.Adapter<RecyclerViewStoriesAdapter.MyViewHolder> {

    private Context mContext;
    List<StoriesData> mData;

    public static final int LAYOUT_DESIGN_0DD=0;
    public static final int LAYOUT_DESIGN_EVEN=1;

    public RecyclerViewStoriesAdapter(Context mContext, List<StoriesData> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i==LAYOUT_DESIGN_EVEN ){
            View view= LayoutInflater.from(mContext).inflate(R.layout.cardview_moments_2,viewGroup,false);
            return new RecyclerViewStoriesAdapter.MyViewHolder(view);
        }else {
            View view=LayoutInflater.from(mContext).inflate(R.layout.cardview_moments_1,viewGroup,false);
            return new RecyclerViewStoriesAdapter.MyViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        if(i==LAYOUT_DESIGN_0DD ){
            Picasso.with(mContext).load(mData.get(i).getStoriesThumbnail())
                    // .into(myViewHolder.profileImages3)
                    .resize(dp2px(200),500).into(myViewHolder.StoriesImages1);

            Picasso.with(mContext).load(mData.get(i).getStoriesThumbnail2())
                    // .into(myViewHolder.profileImages3)
                    .resize(dp2px(200),500).into(myViewHolder.StoriesImages2);

            Picasso.with(mContext).load(mData.get(i).getStoriesThumbnail3())
                    // .into(myViewHolder.profileImages3)
                    .resize(dp2px(200),500).into(myViewHolder.StoriesImages3);
        }else {
            Picasso.with(mContext).load(mData.get(i).getStoriesThumbnail())
                    // .into(myViewHolder.profileImages3)
                    .resize(dp2px(350),1500).into(myViewHolder.StoriesImages1);

            Picasso.with(mContext).load(mData.get(i).getStoriesThumbnail2())
                    // .into(myViewHolder.profileImages3)
                    .resize(dp2px(350),800).into(myViewHolder.StoriesImages2);

            Picasso.with(mContext).load(mData.get(i).getStoriesThumbnail3())
                    // .into(myViewHolder.profileImages3)
                    .resize(dp2px(350),800).into(myViewHolder.StoriesImages3);
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView StoriesImages1,StoriesImages2,StoriesImages3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            StoriesImages1=itemView.findViewById(R.id.story_image1);
            StoriesImages2=itemView.findViewById(R.id.story_image2);
            StoriesImages3=itemView.findViewById(R.id.story_image3);

        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==0){
            return LAYOUT_DESIGN_EVEN;
        }else {
            return LAYOUT_DESIGN_0DD;
        }

    }

    public int dp2px(int dp){
        WindowManager wm =(WindowManager) this.mContext
                .getSystemService(Context.WINDOW_SERVICE);
        Display display=wm.getDefaultDisplay();
        DisplayMetrics displayMetrics=new DisplayMetrics();

        display.getMetrics(displayMetrics);
        return (int) (dp*displayMetrics.density+0.5f);


    }

}
