package com.example.school_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.school_project.Challenges.MainActivity;
import com.example.school_project.assignSkillActivities.AssignSkillActivity;
import com.example.school_project.examActivities.ExamActivity;
import com.example.school_project.homeActivities.HomeActivity;

public class StartingActivity extends AppCompatActivity {
private Button challenges,alert,exam,home,assignSkill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        challenges=findViewById(R.id.challengesBtn);
        alert=findViewById(R.id.alertBtn);
        exam=findViewById(R.id.exam);
        home=findViewById(R.id.homeBtn);
        assignSkill=findViewById(R.id.assignSkillBtn);
        challenges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
startActivity(new Intent(StartingActivity.this, MainActivity.class));
            }
        });
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
startActivity(new Intent(StartingActivity.this, AlertActivity.class));
            }
        });
        exam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
startActivity(new Intent(StartingActivity.this, ExamActivity.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
startActivity(new Intent(StartingActivity.this, HomeActivity.class));
            }
        });
        assignSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
startActivity(new Intent(getApplicationContext(), AssignSkillActivity.class));
            }
        });
    }
}