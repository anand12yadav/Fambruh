package com.example.admin.fambruh.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.fambruh.Adpater.SectionAdapter;
import com.example.admin.fambruh.R;

public class StoriesFragment extends Fragment {

    View v;
   ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_stories, container, false);

        viewPager=v.findViewById(R.id.viewPager);

        //connecting PyPagerAdapter to viewPager
       // adapterViewPager = new MypagerAdapter(getChildFragmentManager());

        //to open camera fragment first as in snapchat as case 0 is first we want case 1 to be open first


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager){
        SectionAdapter adapter=new SectionAdapter(getChildFragmentManager());
        adapter.addFragment(new NotificationFragment());
        adapter.addFragment(new GlobalStoriesFragment());

        viewPager.setAdapter(adapter);
    }
}

