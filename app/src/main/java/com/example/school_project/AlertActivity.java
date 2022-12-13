package com.example.school_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.school_project.Alert_Adapter.AlertAdapter;
import com.example.school_project.Alert_Adapter.CalenderAdapter;
import com.example.school_project.Alert_Model.Alerts_Detail;
import com.example.school_project.Alert_Model.Pojo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AlertActivity extends AppCompatActivity {
private RecyclerView alertRV,calenderRV;
AlertAdapter alertAdapter;
private CalenderAdapter overdueAdapter;
private List<Alerts_Detail> alertModelList;
private List<com.example.school_project.Alert_Model.Calendar> alertModelsCalender;
private ImageView backArrowCalenderIV,forwardArrowCalenderIV;
private TextView calenderDateTV;
private String[] monthsArray;
int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        getSupportActionBar().hide();
        backArrowCalenderIV=findViewById(R.id.backArrowCalenderIV);
        forwardArrowCalenderIV=findViewById(R.id.forwardArrowCalenderIV);
        calenderDateTV=findViewById(R.id.calenderDateTV);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        calenderDateTV.setText(Utils.getMonthName(currentMonth, Locale.US, false) + " " + Calendar.getInstance().get(Calendar.YEAR));
        monthsArray=new String[]{"January 2022","February 2022","March 2022","April 2022","May 2022","June 2022","July 2022","August 2022","September 2022","October 2022","November 2022","December 2022"};
        forwardArrowCalenderIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position<monthsArray.length-1){
                    position=position+1;
                    calenderDateTV.setText(monthsArray[position]);
                }
                else {
                    position=0;
                    calenderDateTV.setText(monthsArray[position]);
                }
            }
        });
        backArrowCalenderIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position!=0){
                    position=position-1;
                    calenderDateTV.setText(monthsArray[position]);
                }
                else{
                    position=monthsArray.length-1;
                    calenderDateTV.setText(monthsArray[position]);
                }
            }
        });
alertRV=findViewById(R.id.alertRV);
calenderRV=findViewById(R.id.calenderRV);
alertRV.setLayoutManager(new LinearLayoutManager(this));
alertModelList=new ArrayList<>();
alertAdapter=new AlertAdapter(AlertActivity.this,alertModelList);
alertRV.setAdapter(alertAdapter);
        String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "alert-json");
        Gson gson = new Gson();
        Pojo lstObject = gson.fromJson(jsonFileString, Pojo.class);
alertModelList.addAll(lstObject.getData().getAlerts().getAlerts_detail());

        calenderRV.setLayoutManager(new LinearLayoutManager(this));
        alertModelsCalender=new ArrayList<>();
        overdueAdapter=new CalenderAdapter(this,alertModelsCalender);
        calenderRV.setAdapter(overdueAdapter);

        String jsonFileStringCalender = Utils.getJsonFromAssets(getApplicationContext(), "alert-json");
        Gson gsonCalender = new Gson();
        Pojo lstObjectCalender = gsonCalender.fromJson(jsonFileStringCalender, Pojo.class);
alertModelsCalender.addAll(lstObjectCalender.getData().getCalendar());
    }
}