package com.example.school_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskCompleteActivity extends AppCompatActivity {
    private TextView fromTV,assignedTV,dueTV,statusTV;
    private ImageView taskCompleteCrossIV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_complete);
        getSupportActionBar().hide();
        taskCompleteCrossIV=findViewById(R.id.taskCompleteCrossIV);
        fromTV=findViewById(R.id.taskCompFromTV);
        assignedTV=findViewById(R.id.taskCompAssignedTV);
        dueTV=findViewById(R.id.taskCompDueTV);
        statusTV=findViewById(R.id.taskCompStatusTV);
        taskCompleteCrossIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TaskCompleteActivity.this, OverdueActivity.class));
            }
        });
        Intent intent=getIntent();
        String getAssignedFrom= intent.getStringExtra("assignedFrom");
        String getDueDate=intent.getStringExtra("dueDate");
        String getAssignedDate=intent.getStringExtra("assignedDate");
        String getStatus= intent.getStringExtra("status");
        assignedTV.setText(getAssignedDate);
        statusTV.setText(getStatus);
        fromTV.setText(getAssignedFrom);
        dueTV.setText(getDueDate);
    }
}