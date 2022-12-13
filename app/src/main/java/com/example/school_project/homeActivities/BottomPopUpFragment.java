package com.example.school_project.homeActivities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.school_project.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomPopUpFragment extends BottomSheetDialogFragment {
TextView titleTV,descTV;
Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_bottom_pop_up, container, false);
       titleTV=view.findViewById(R.id.bottomFragTitleTV);
       descTV=view.findViewById(R.id.bottomFragDescTV);
       button=view.findViewById(R.id.bottomFragButton);
        SharedPreferences sharedPreferences= getContext().getSharedPreferences("myKey", Context.MODE_PRIVATE);
        String title=sharedPreferences.getString("title","");
        String desc=sharedPreferences.getString("description","");
        titleTV.setText(title);
        descTV.setText(desc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://www.computernetworkingnotes.com/linux-tutorials/network-configuration-files-in-linux-explained.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
       return view;
    }
}