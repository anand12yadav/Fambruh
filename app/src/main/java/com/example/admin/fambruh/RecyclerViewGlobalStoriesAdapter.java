package com.example.admin.fambruh;

import android.content.Context;
import android.provider.Settings;
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

public class RecyclerViewGlobalStoriesAdapter extends RecyclerView.Adapter<RecyclerViewGlobalStoriesAdapter.MyViewHolder> {

    private Context mContext;
    List<GlobalStoriesData> mData;

    public static final int LAYOUT_DESIGN_0DD = 0;
    public static final int LAYOUT_DESIGN_EVEN = 1;

    public RecyclerViewGlobalStoriesAdapter(Context mContext, List<GlobalStoriesData> mData) {
            this.mContext = mContext;
             this.mData = mData;
         }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(i==LAYOUT_DESIGN_EVEN ){
            View view= LayoutInflater.from(mContext).inflate(R.layout.global_stories_card_2,viewGroup,false);
            return new RecyclerViewGlobalStoriesAdapter.MyViewHolder(view);
        }else {
            View view=LayoutInflater.from(mContext).inflate(R.layout.global_stories_card_1,viewGroup,false);
            return new RecyclerViewGlobalStoriesAdapter.MyViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        if(i==LAYOUT_DESIGN_0DD ){
            Picasso.with(mContext).load(mData.get(i).getGlobalStoriesThumbnail())
                    // .into(myViewHolder.profileImages3)
                    .resize(dp2px(200),500).into(myViewHolder.GlobalStoriesImages1);

            Picasso.with(mContext).load(mData.get(i).getGlobalStoriesThumbnail2())
                    // .into(myViewHolder.profileImages3)
                    .resize(dp2px(200),500).into(myViewHolder.GlobalStoriesImages2);

            Picasso.with(mContext).load(mData.get(i).getGlobalStoriesThumbnail3())
                    // .into(myViewHolder.profileImages3)
                    .resize(dp2px(200),500).into(myViewHolder.GlobalStoriesImages3);
        }else {
            Picasso.with(mContext).load(mData.get(i).getGlobalStoriesThumbnail())
                    // .into(myViewHolder.profileImages3)
                    .resize(dp2px(350),1500).into(myViewHolder.GlobalStoriesImages1);

            Picasso.with(mContext).load(mData.get(i).getGlobalStoriesThumbnail2())
                    // .into(myViewHolder.profileImages3)
                    .resize(dp2px(350),800).into(myViewHolder.GlobalStoriesImages2);

            Picasso.with(mContext).load(mData.get(i).getGlobalStoriesThumbnail3())
                    // .into(myViewHolder.profileImages3)
                    .resize(dp2px(350),800).into(myViewHolder.GlobalStoriesImages3);
        }


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }




    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView GlobalStoriesImages1, GlobalStoriesImages2, GlobalStoriesImages3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            GlobalStoriesImages1 = itemView.findViewById(R.id.Global_story_image1);
            GlobalStoriesImages2 = itemView.findViewById(R.id.Global_story_image2);
            GlobalStoriesImages3 = itemView.findViewById(R.id.Global_story_image3);

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
