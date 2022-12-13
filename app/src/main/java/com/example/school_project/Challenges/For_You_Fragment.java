package com.example.school_project.Challenges;

import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.school_project.Adapter.ForYouCurrentlyAdapter;
import com.example.school_project.Model.Pojo;
import com.example.school_project.R;
import com.example.school_project.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class For_You_Fragment extends Fragment{
RecyclerView recyclerView,recyclerViewR;
List<Pojo> pojoListForYou;
List<Pojo> pojoListRecommended;
int[] arrayCurrently;
int[] arrayRecommended;
int[] rankArrayForYou;
int[] rankRecommended;
ForYouCurrentlyAdapter forYouCurrentlyAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_for__you_, container, false);
        recyclerView=view.findViewById(R.id.recyclerForYouC);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        pojoListForYou=new ArrayList<>();
        rankArrayForYou=new int[]{0,1,4,3};
        arrayCurrently=new int[]{R.drawable.vegetable_fruits,R.drawable.animal,R.drawable.transport,R.drawable.flag};
        forYouCurrentlyAdapter=new ForYouCurrentlyAdapter(getContext(),pojoListForYou);
        recyclerView.setAdapter(forYouCurrentlyAdapter);
        try {
            JSONObject jsonObject=new JSONObject(Objects.requireNonNull(Utils.JsonDataFromAssetSample(getContext())));
            JSONObject jsonData=jsonObject.getJSONObject("data");
            JSONArray playingArray=jsonData.getJSONArray("playing_games");
            for(int i=0;i< playingArray.length();i++){
                JSONObject jsonObject1=playingArray.getJSONObject(i);
                String title=jsonObject1.getString("game_title");
                String subject=jsonObject1.getString("subject_name");
                int getGameLevels= jsonObject1.getInt("game_levels");
                int getCompletedLevels= jsonObject1.getInt("completed_level");
                String getCompletedStatus=jsonObject1.getString("completed_status");

                pojoListForYou.add(new Pojo(title,subject,getCompletedStatus,arrayCurrently[i],getCompletedLevels,rankArrayForYou[i],getGameLevels));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
recyclerViewR=view.findViewById(R.id.recyclerForYouR);
recyclerViewR.setLayoutManager(new GridLayoutManager(getContext(),3));
pojoListRecommended=new ArrayList<>();
rankRecommended=new int[]{4,5,1,4,2};
arrayRecommended=new int[]{R.drawable.monumant_museum,R.drawable.vegetable_fruits,R.drawable.animal,R.drawable.transport,R.drawable.flag};
        recyclerViewR.setAdapter(new ForYouCurrentlyAdapter(getContext(),pojoListRecommended));
        try {
            JSONObject jsonObject=new JSONObject(Objects.requireNonNull(Utils.JsonDataFromAssetSample(getContext())));
            JSONObject jsonData=jsonObject.getJSONObject("data");
            JSONArray recommendedArray=jsonData.getJSONArray("recommended_games");
            for(int i=0;i< recommendedArray.length();i++){
                JSONObject jsonObject1=recommendedArray.getJSONObject(i);
                String getGameTitle=jsonObject1.getString("game_title");
                String getSubjName=jsonObject1.getString("subject_name");
                int getGameLevels=jsonObject1.getInt("game_levels");
                int getCompletedLevels=jsonObject1.getInt("completed_level");
                String getCompletedStatus=jsonObject1.getString("completed_status");

               pojoListRecommended.add(new Pojo(getGameTitle,getSubjName,getCompletedStatus,arrayRecommended[i],getCompletedLevels,rankRecommended[i],getGameLevels));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }
}