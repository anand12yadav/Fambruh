package com.example.admin.fambruh.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.fambruh.HomePageProfilesData;
import com.example.admin.fambruh.R;
import com.example.admin.fambruh.RecyclerViewProfileAdapter;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {


    View v;
    List<HomePageProfilesData> listProfile;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_explore, container, false);
        recyclerView=v.findViewById(R.id.recycler_view);
       // GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
       // gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
         //  @Override
        //   public int getSpanSize(int i) {
         //     return (i%2==0? 2:1);
        //   }


      // });
       // StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        RecyclerViewProfileAdapter recyclerViewAdapter=new RecyclerViewProfileAdapter(getContext(),listProfile);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        return v;



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listProfile=new ArrayList<>();
        listProfile.add(new HomePageProfilesData(R.drawable.img3,R.drawable.img2,R.drawable.img3));
        listProfile.add(new HomePageProfilesData(R.drawable.img3,R.drawable.img3,R.drawable.img1));
        listProfile.add(new HomePageProfilesData(R.drawable.img3,R.drawable.img4,R.drawable.img5));
        listProfile.add(new HomePageProfilesData(R.drawable.img4,R.drawable.img3,R.drawable.img2));
        listProfile.add(new HomePageProfilesData(R.drawable.img5,R.drawable.img4,R.drawable.img3));



    }


}
