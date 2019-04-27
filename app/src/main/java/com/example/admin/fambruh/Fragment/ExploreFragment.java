package com.example.admin.fambruh.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.fambruh.Profiles;
import com.example.admin.fambruh.R;
import com.example.admin.fambruh.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {


    View v;
    List<Profiles> listProfile;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_explore, container, false);
        recyclerView=v.findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(getContext(),listProfile);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(recyclerViewAdapter);

        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listProfile=new ArrayList<>();
        listProfile.add(new Profiles(R.drawable.img1));
        listProfile.add(new Profiles(R.drawable.img2));
        listProfile.add(new Profiles(R.drawable.img3));
        listProfile.add(new Profiles(R.drawable.img4));
        listProfile.add(new Profiles(R.drawable.img5));



    }


}
