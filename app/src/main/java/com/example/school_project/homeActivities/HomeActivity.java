package com.example.school_project.homeActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.school_project.R;
import com.example.school_project.examActivities.RetrofitClient;
import com.example.school_project.homeAdapters.HomeAdapter;
import com.example.school_project.homeModel.DataArray;
import com.example.school_project.homeModel.HomeModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private List<DataArray> dataArrayList;
private HomeAdapter homeAdapter;
String[] spinnerArray;
Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        recyclerView=findViewById(R.id.homeRV);
        spinner=findViewById(R.id.spinner1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataArrayList=new ArrayList<>();
        homeAdapter=new HomeAdapter(this,dataArrayList);
        recyclerView.setAdapter(homeAdapter);
        RetrofitClient retrofitClient=new RetrofitClient();
        retrofitClient.api().getHomeModel().enqueue(new Callback<HomeModel>() {
            @Override
            public void onResponse(Call<HomeModel> call, Response<HomeModel> response) {
                HomeModel homeModel=response.body();
                dataArrayList.addAll(homeModel.getData_array());
                homeAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<HomeModel> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Failure occur", Toast.LENGTH_SHORT).show();
            }
        });
        spinnerArray=new String[]{"Add","Unread"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,spinnerArray);
        spinner.setAdapter(adapter);
    }
}