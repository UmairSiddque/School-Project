package com.example.school_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class TaskPendingActivity extends AppCompatActivity {
private TextView fromTV,assignedTV,dueTV,statusTV;
private ImageView taskPendingCrossIV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_pending);
        getSupportActionBar().hide();
        taskPendingCrossIV=findViewById(R.id.textPendingCrossIV);
        fromTV=findViewById(R.id.taskPendingFromTV);
        assignedTV=findViewById(R.id.taskPendingAssignedTV);
        dueTV=findViewById(R.id.taskPendingDueTV);
        statusTV=findViewById(R.id.taskPendingStatusTV);
        taskPendingCrossIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(TaskPendingActivity.this, OverdueActivity.class).putExtra("word",(Serializable) new Object() )
//                );
                startActivity(new Intent(TaskPendingActivity.this,OverdueActivity.class));
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