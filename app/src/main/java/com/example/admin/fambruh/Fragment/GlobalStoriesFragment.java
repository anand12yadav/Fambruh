package com.example.admin.fambruh.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.fambruh.GlobalStoriesData;
import com.example.admin.fambruh.R;
import com.example.admin.fambruh.RecyclerViewGlobalStoriesAdapter;

import java.util.ArrayList;
import java.util.List;

public class GlobalStoriesFragment extends Fragment {

    View v;
    List<GlobalStoriesData> listGlobalStories;
    private RecyclerView recyclerView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_global_stories, container, false);
        recyclerView=v.findViewById(R.id.Global_Stories_RecyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        RecyclerViewGlobalStoriesAdapter recyclerViewAdapter=new RecyclerViewGlobalStoriesAdapter(getContext(),listGlobalStories);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listGlobalStories=new ArrayList<>();
        listGlobalStories.add(new GlobalStoriesData(R.drawable.img3,R.drawable.img2,R.drawable.img3));
        listGlobalStories.add(new GlobalStoriesData(R.drawable.img3,R.drawable.img3,R.drawable.img1));
        listGlobalStories.add(new GlobalStoriesData(R.drawable.img3,R.drawable.img4,R.drawable.img5));
        listGlobalStories.add(new GlobalStoriesData(R.drawable.img4,R.drawable.img3,R.drawable.img2));
        listGlobalStories.add(new GlobalStoriesData(R.drawable.img5,R.drawable.img4,R.drawable.img3));
    }
}
