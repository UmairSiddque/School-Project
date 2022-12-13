package com.example.school_project.examActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.school_project.Alert_Model.Pojo;
import com.example.school_project.R;
import com.example.school_project.Utils;
import com.example.school_project.examAdapter.DatesheetAdapter;
import com.example.school_project.examModel.DateSheet;
import com.example.school_project.examModel.ExamModel;
import com.example.school_project.examModel.ExamModel1;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatesheetActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private DatesheetAdapter datesheetAdapter;
private List<DateSheet> examModelList;
private ImageView backArrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datesheet);
        getSupportActionBar().hide();
        backArrow=findViewById(R.id.examDatesheetBackArrowIV);
        recyclerView=findViewById(R.id.examDatesheetRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        examModelList=new ArrayList<>();
        datesheetAdapter=new DatesheetAdapter(this,examModelList);
        recyclerView.setAdapter(datesheetAdapter);
        RetrofitClient retrofitClient=new RetrofitClient();
        retrofitClient.api().call().enqueue(new Callback<ExamModel1>() {
            @Override
            public void onResponse(Call<ExamModel1> call, Response<ExamModel1> response) {
                ExamModel1 examModel1 = response.body();
examModelList.addAll(examModel1.getData().getDate_sheet());
datesheetAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ExamModel1> call, Throwable t) {
                Toast.makeText(DatesheetActivity.this, "Failure occur", Toast.LENGTH_SHORT).show();
            }
        });


        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ExamActivity.class));
            }
        });
    }
}