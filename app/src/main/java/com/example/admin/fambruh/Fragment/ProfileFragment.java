package com.example.admin.fambruh.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.fambruh.Account_SettingsActivity;
import com.example.admin.fambruh.R;
import com.example.admin.fambruh.RecyclerViewMomentStoriesAdapter;
import com.example.admin.fambruh.MomentStoriesData;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    View v;
    List<MomentStoriesData> listStories;
    private RecyclerView recyclerView;
    ImageView settings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_profile, container, false);
        recyclerView=v.findViewById(R.id.storiesData_recyclerView);
        settings=v.findViewById(R.id.go_to_settings);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        RecyclerViewMomentStoriesAdapter recyclerViewAdapter=new RecyclerViewMomentStoriesAdapter(getContext(),listStories);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), Account_SettingsActivity.class);
                startActivity(intent);

            }
        });

        return v;



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listStories=new ArrayList<>();
        listStories.add(new MomentStoriesData(R.drawable.img3,R.drawable.img2,R.drawable.img3));
        listStories.add(new MomentStoriesData(R.drawable.img3,R.drawable.img3,R.drawable.img1));
        listStories.add(new MomentStoriesData(R.drawable.img3,R.drawable.img4,R.drawable.img5));
        listStories.add(new MomentStoriesData(R.drawable.img4,R.drawable.img3,R.drawable.img2));
        listStories.add(new MomentStoriesData(R.drawable.img5,R.drawable.img4,R.drawable.img3));
    }
}
