package com.example.school_project.examActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.school_project.R;
import com.example.school_project.examAdapter.DownloadAdapter;
import com.example.school_project.examModel.ExamModel;

import java.util.ArrayList;
import java.util.List;

public class DownloadActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private List<ExamModel> examModelList;
private DownloadAdapter downloadAdapter;
private ImageView backIV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        getSupportActionBar().hide();
        backIV=findViewById(R.id.examDownloadBackIV);
recyclerView=findViewById(R.id.examDownloadRV);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
examModelList=new ArrayList<>();
downloadAdapter=new DownloadAdapter(this,examModelList);
recyclerView.setAdapter(downloadAdapter);
examModelList.add(new ExamModel("Term 1 Final",R.drawable.file_download_icon));
        examModelList.add(new ExamModel("Term 2 Final",R.drawable.file_download_icon));
        examModelList.add(new ExamModel("Term 2 Final",R.drawable.file_download_icon));
        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ExamActivity.class));
            }
        });
    }
}