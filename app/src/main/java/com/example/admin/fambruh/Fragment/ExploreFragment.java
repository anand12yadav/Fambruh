package com.example.admin.fambruh.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.admin.fambruh.Constants;
import com.example.admin.fambruh.HomePageProfilesData;
import com.example.admin.fambruh.MainActivity;
import com.example.admin.fambruh.R;
import com.example.admin.fambruh.RecyclerViewProfileAdapter;
import com.example.admin.fambruh.SocialInfoActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class ExploreFragment extends Fragment {


    View v;
    List<HomePageProfilesData> listProfile;
    private RecyclerView recyclerView;
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    public final String TAG ="Home Fragment Activity";
    private final String JSON_URL = Constants.loginUrl;




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
