package com.example.admin.fambruh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    List<Profiles> mData;

    public static final int LAYOUT_DESIGN_0DD=0;
    public static final int LAYOUT_DESIGN_EVEN=1;


    public RecyclerViewAdapter(Context mContext, List<Profiles> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       // View view;
      //  LayoutInflater mInflater=LayoutInflater.from(mContext);
      //  view=mInflater.inflate(R.layout.cardview_profiles,viewGroup,false);
        if(i==LAYOUT_DESIGN_EVEN ){
          View view=LayoutInflater.from(mContext).inflate(R.layout.cardview_profiles2,viewGroup,false);
          return new MyViewHolder(view);
        }else {
            View view=LayoutInflater.from(mContext).inflate(R.layout.cardview_profiles,viewGroup,false);
            return new MyViewHolder(view);
        }
        //return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.profileImages1.setImageResource(mData.get(i).getThumbnail());
        myViewHolder.profileImages2.setImageResource(mData.get(i).getThumbnail2());
        myViewHolder.profileImages3.setImageResource(mData.get(i).getThumbnail3());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImages1,profileImages2,profileImages3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImages1=itemView.findViewById(R.id.profile_image1);
            profileImages2=itemView.findViewById(R.id.profile_image2);
            profileImages3=itemView.findViewById(R.id.profile_image3);


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

}
