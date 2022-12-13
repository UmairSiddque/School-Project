package com.example.school_project.Challenges;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class All_Challenges_Fragment extends Fragment {
    private RecyclerView recyclerView;
    List<Pojo> pojoListAllChallenges;
     ForYouCurrentlyAdapter forYouCurrentlyAdapter;
     int[] arrayAll;
     int[] rankAll;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_all__challenges_, container, false);
        recyclerView=view.findViewById(R.id.recyclerAllChallenges);
        rankAll=new int[]{2,9,0,6,8,1,4,5,7,9,4,3,2,4,5,7,8,4,7,4,1,3,9,6};
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        pojoListAllChallenges=new ArrayList<>();
        arrayAll=new int[]{R.drawable.monumant_museum,R.drawable.cleaning,R.drawable.footbal,R.drawable.basketball2,R.drawable.skydiving,R.drawable.transport,R.drawable.aviation,R.drawable.vegetable_fruits,R.drawable.cleaning,R.drawable.footbal,R.drawable.basketball2,R.drawable.transport,R.drawable.t20_cric,R.drawable.monument_museum2,R.drawable.monumant_museum,R.drawable.monument_museum2,R.drawable.vegetable_fruits,R.drawable.animal,R.drawable.transport,R.drawable.basketball3,R.drawable.footbal,R.drawable.aviation,R.drawable.footbal,R.drawable.flag};
        forYouCurrentlyAdapter=new ForYouCurrentlyAdapter(getContext(),pojoListAllChallenges);
        recyclerView.setAdapter(forYouCurrentlyAdapter);

        try {
            JSONObject jsonObject=new JSONObject(Objects.requireNonNull(Utils.JsonDataFromAssetSample(getContext())));
            JSONObject jsonData=jsonObject.getJSONObject("data");
            JSONArray playingArray=jsonData.getJSONArray("all_games");
            for(int i=0;i< playingArray.length();i++){
                JSONObject jsonObject1=playingArray.getJSONObject(i);
                String getGameTitle=jsonObject1.getString("game_title");
                String getSubjName=jsonObject1.getString("subject_name");
                int getGameLevels= jsonObject1.getInt("game_levels");
                int getCompletedLevels= jsonObject1.getInt("completed_level");
                String getCompletedStatus=jsonObject1.getString("completed_status");
                pojoListAllChallenges.add(new Pojo(getGameTitle,getSubjName,getCompletedStatus,arrayAll[i],getCompletedLevels,rankAll[i],getGameLevels));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return view;
    }

}