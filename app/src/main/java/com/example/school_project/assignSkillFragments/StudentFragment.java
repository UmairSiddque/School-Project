package com.example.school_project.assignSkillFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.school_project.R;
import com.example.school_project.assignSkillAdapter.AssignSkillAdapter;
import com.example.school_project.assignSkillModel.AssignSkillModel;

import java.util.ArrayList;
import java.util.List;

public class StudentFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<AssignSkillModel> assignSkillModelList;
    private AssignSkillAdapter assignSkillAdapter;
    private Spinner spinner;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_student, container, false);
        recyclerView=view.findViewById(R.id.assignFragStudentRV);
        spinner=view.findViewById(R.id.assignSpinner2);
        String[] items=new String[]{"FSC-1"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item,items);
        spinner.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        assignSkillModelList=new ArrayList<>();
        assignSkillAdapter=new AssignSkillAdapter(getContext(),assignSkillModelList);
        recyclerView.setAdapter(assignSkillAdapter);
        assignSkillModelList.add(new AssignSkillModel("Danish A"));
        assignSkillModelList.add(new AssignSkillModel("Kashif A"));
        assignSkillModelList.add(new AssignSkillModel("Shaheen A"));
        assignSkillModelList.add(new AssignSkillModel("Asif A"));
        assignSkillModelList.add(new AssignSkillModel("Shadab A"));
        assignSkillModelList.add(new AssignSkillModel("Ali A"));
        assignSkillModelList.add(new AssignSkillModel("Danish A"));
        return view;
    }
}