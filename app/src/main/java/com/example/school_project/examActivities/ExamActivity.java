package com.example.school_project.examActivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.school_project.R;
import com.example.school_project.StartingActivity;
import com.example.school_project.examAdapter.ExamViewPagerAdapter;
import com.example.school_project.examAdapter.Term1Adapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.net.URISyntaxException;
import java.util.Objects;

public class ExamActivity extends AppCompatActivity implements Term1Adapter.AdapterCallBack {
private ViewPager2 viewPager2;
private TabLayout tabLayout;
private ExamViewPagerAdapter examViewPagerAdapter;
private Button downloadBtn,datesheetBtn;
private ImageView backArrowIV;
 private TextView datesheetTV,upcomingTV;
private String[] examItems=new String[]{"Term01","Term02"};
private Term1Adapter.AdapterCallBack adapterCallBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        getSupportActionBar().hide();
        adapterCallBack=this;
        datesheetTV = findViewById(R.id.examDatesheetTV);
        upcomingTV = findViewById(R.id.examUpcomingTV);
        backArrowIV = findViewById(R.id.examActivityBackArrowIV);
        downloadBtn = findViewById(R.id.examDownloadBtn);
        datesheetBtn = findViewById(R.id.examDatesheetBtn);
        viewPager2 = findViewById(R.id.examViewPager2);
        tabLayout = findViewById(R.id.examtablayout);
//        switchTabs(tabLayout.getTabAt(0).getText().toString());
        examViewPagerAdapter=new ExamViewPagerAdapter(this,adapterCallBack );
//        examViewPagerAdapter = new ExamViewPagerAdapter(this);
        viewPager2.setAdapter(examViewPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> tab.setText(examItems[position]))).attach();
        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamActivity.this, DownloadActivity.class));
            }
        });
        datesheetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExamActivity.this, DatesheetActivity.class));
            }
        });
        backArrowIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), StartingActivity.class));
            }
        });
        datesheetBtn.setVisibility(View.INVISIBLE);
        datesheetTV.setText("To be announced");
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tabLayout.getTabAt(0).isSelected()){
                    datesheetBtn.setVisibility(View.INVISIBLE);
                    datesheetTV.setText("To be announced");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                datesheetBtn.setVisibility(View.VISIBLE);
                datesheetTV.setText("Datesheet has been announced");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
//                datesheetBtn.setVisibility(View.INVISIBLE);
//                datesheetTV.setText("Datesheet has been announced");
            }
        });

    }

    @Override
    public void switchTabs(String value) {
    }
    }




