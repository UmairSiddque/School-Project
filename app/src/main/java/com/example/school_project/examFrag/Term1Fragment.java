package com.example.school_project.examFrag;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.school_project.R;
import com.example.school_project.Utils;
import com.example.school_project.examActivities.ExamActivity;
import com.example.school_project.examActivities.RetrofitClient;
import com.example.school_project.examAdapter.Term1Adapter;
import com.example.school_project.examModel.ExamModel;
import com.example.school_project.examModel.ExamModel1;
import com.example.school_project.examModel.T1;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Term1Fragment extends Fragment implements Term1Adapter.AdapterCallBack {
    public static RecyclerView recyclerView;
    public static List<T1> t1List;
    TextView percentageTerminalTV,percentageMonthlyTV,totalTerminalTV,totalMonthlyTV;
    ExamModel examModel;
    String status;
    Term1Adapter.AdapterCallBack adapterCallBack;
    public Term1Fragment(Term1Adapter.AdapterCallBack adapterCallBack) {
        this.adapterCallBack=adapterCallBack;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_term1, container, false);
      percentageTerminalTV=view.findViewById(R.id.frag1PercentageTerminalTV);
        percentageMonthlyTV=view.findViewById(R.id.frag1PercentageMonthlyTV);
        totalTerminalTV=view.findViewById(R.id.frag1TotalTerminalTV);
        totalMonthlyTV=view.findViewById(R.id.frag1TotalMonthlyTV);
       recyclerView=view.findViewById(R.id.examTerm1RV);
       status="pending";
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       t1List=new ArrayList<>();
       Term1Adapter term1Adapter=new Term1Adapter(getContext(),t1List,adapterCallBack);
       recyclerView.setAdapter(term1Adapter);
        RetrofitClient retrofitClient=new RetrofitClient();
       retrofitClient.api().call().enqueue(new Callback<ExamModel1>() {
           @Override
           public void onResponse(Call<ExamModel1> call, Response<ExamModel1> response) {
ExamModel1 examModel1= (ExamModel1) response.body();
t1List.addAll(examModel1.getData().getExam_result().getT1());
term1Adapter.notifyDataSetChanged();
           }
           @Override
           public void onFailure(Call<ExamModel1> call, Throwable t) {
               Toast.makeText(getContext(), "Failure occur", Toast.LENGTH_SHORT).show();
           }
       });

int a=0;
int a1=0;
int t=0;
int t1=0;
        for(int i=0;i<t1List.size();i++){
            int monthly_total_marks=t1List.get(i).getMonthly_total_marks();
            int monthlyObtMarks=t1List.get(i).getMonthly_obtained_marks();

            int terminalTotalMarks=t1List.get(i).getTerminal_total_marks();
            int terminalMarksObt=t1List.get(i).getTerminal_obtained_marks();
            t=t+terminalTotalMarks;
            t1=t1+terminalMarksObt;
            a1=a1+monthlyObtMarks;
      a=a+monthly_total_marks;
      float percentageMonthly=a1*100/a;
      float percentageTerminal=t1*100/t;
      String s=Integer.toString(a);
      String s1=Integer.toString(a1);
      String terminalTotal=Integer.toString(t);
      String terminalObt=Integer.toString(t1);
      String p=Float.toString(percentageMonthly);
      String p1=Float.toString(percentageTerminal);
       totalMonthlyTV.setText(s1+"/"+s);
       totalTerminalTV.setText(terminalObt+"/"+terminalTotal);
       percentageMonthlyTV.setText(p+"%");
       percentageTerminalTV.setText(p1+"%");
        }
        return view;

    }

    @Override
    public void switchTabs(String value) {

    }
}