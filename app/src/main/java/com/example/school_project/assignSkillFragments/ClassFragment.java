package com.example.school_project.assignSkillFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.school_project.R;
import com.example.school_project.assignSkillAdapter.AssignSkillAdapter;
import com.example.school_project.assignSkillModel.AssignSkillModel;

import java.util.ArrayList;
import java.util.List;

public class ClassFragment extends Fragment {
    private RecyclerView recyclerView;
    private AssignSkillAdapter assignSkillAdapter;
    private List<AssignSkillModel> assignSkillModelList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_class, container, false);
        recyclerView=view.findViewById(R.id.assignFragClassRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        assignSkillModelList=new ArrayList<>();
        assignSkillAdapter=new AssignSkillAdapter(getContext(),assignSkillModelList);
        recyclerView.setAdapter(assignSkillAdapter);
        assignSkillModelList.add(new AssignSkillModel("FSI-C"));
        assignSkillModelList.add(new AssignSkillModel("FSI-E"));
        assignSkillModelList.add(new AssignSkillModel("FSI-R"));
        assignSkillModelList.add(new AssignSkillModel("FSI-A"));
        assignSkillModelList.add(new AssignSkillModel("FSI-U"));
        return view;
    }
}