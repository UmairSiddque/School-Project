package com.example.school_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.school_project.Alert_Adapter.CalenderAdapter;
import com.example.school_project.Alert_Adapter.OverdueAdapter;
import com.example.school_project.Alert_Model.Over_Dues;
import com.example.school_project.Alert_Model.Pojo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class OverdueActivity extends AppCompatActivity {
private RecyclerView overdueRV;
private OverdueAdapter overdueAdapter;
private List<Over_Dues> alertModels;
private ImageView overdueBackArrowIV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overdue);
        getSupportActionBar().hide();
//        (Object) getIntent().getSerializableExtra("word");
        overdueBackArrowIV=findViewById(R.id.overdueBackArrowIV);
        overdueRV=findViewById(R.id.overdueRV);
        overdueBackArrowIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OverdueActivity.this, AlertActivity.class));
            }
        });
overdueRV.setLayoutManager(new LinearLayoutManager(this));
alertModels=new ArrayList<>();
overdueAdapter=new OverdueAdapter(OverdueActivity.this,alertModels);

overdueRV.setAdapter(overdueAdapter);
        Gson gson = new Gson();
        String jsonFileStringOverdue = Utils.getJsonFromAssets(getApplicationContext(), "alert-json");
        Pojo lstObject = gson.fromJson(jsonFileStringOverdue, Pojo.class);
        alertModels.addAll(lstObject.getData().getOver_dues());
        overdueRV.getAdapter().notifyDataSetChanged();
    }

}