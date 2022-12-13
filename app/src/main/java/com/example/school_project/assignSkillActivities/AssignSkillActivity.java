package com.example.school_project.assignSkillActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.school_project.R;
import com.example.school_project.StartingActivity;
import com.example.school_project.assignSkillFragments.ClassFragment;
import com.example.school_project.assignSkillFragments.StudentFragment;

public class AssignSkillActivity extends AppCompatActivity {
private Button studentBtn,classBtn;
private ImageView backArrow;
FragmentContainerView fragmentContainerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_skill);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(getResources().getColor(R.color.assignActivityColor));
        studentBtn=findViewById(R.id.assignStudentBtn);
        backArrow=findViewById(R.id.assignBackArrowIV);
        classBtn=findViewById(R.id.assignClassBtn);
        classBtn.setBackgroundResource(R.drawable.assign_class_btn_bg);
        classBtn.setTextColor(getResources().getColor(R.color.white));
        studentBtn.setBackgroundResource(R.drawable.assign_student_btn_bg);
        studentBtn.setTextColor(getResources().getColor(R.color.assignBtnTextColor));
        studentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentBtn.setBackgroundResource(R.drawable.assign_class_btn_bg);
                studentBtn.setTextColor(getResources().getColor(R.color.white));
                classBtn.setBackgroundResource(R.drawable.assign_student_btn_bg);
                classBtn.setTextColor(getResources().getColor(R.color.assignBtnTextColor));
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, StudentFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();
            }
        });
        classBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                classBtn.setBackgroundResource(R.drawable.assign_class_btn_bg);
                classBtn.setTextColor(getResources().getColor(R.color.white));
                studentBtn.setBackgroundResource(R.drawable.assign_student_btn_bg);
                studentBtn.setTextColor(getResources().getColor(R.color.assignBtnTextColor));
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, ClassFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name") // name can be null
                        .commit();
            }
        });
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), StartingActivity.class));
            }
        });
    }
}