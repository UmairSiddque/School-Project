package com.example.school_project.Challenges;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

import com.example.school_project.Adapter.ViewPagerAdapter;
import com.example.school_project.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
ViewPager2 viewPager2;
ViewPagerAdapter viewPagerAdapter;
TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] item=new String[]{"For You","All Challenges"};
getSupportActionBar().hide();
viewPager2=findViewById(R.id.viewpager2);
tabLayout=findViewById(R.id.tablayout);
viewPagerAdapter=new ViewPagerAdapter(this);
viewPager2.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) ->tab.setText(item[position]) )).attach();
    }
}