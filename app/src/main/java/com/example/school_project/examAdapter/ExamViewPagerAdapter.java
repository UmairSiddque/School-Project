package com.example.school_project.examAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.school_project.examFrag.Term1Fragment;

public class ExamViewPagerAdapter extends FragmentStateAdapter {
    String[] examItems=new String[]{"Term01","Term02"};
    Term1Adapter.AdapterCallBack adapterCallBack;
    public ExamViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, Term1Adapter.AdapterCallBack adapterCallBack) {
        super(fragmentActivity);
        this.adapterCallBack=adapterCallBack;
    }

    public ExamViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
            case 1:

                return new Term1Fragment(adapterCallBack);
        }
        return new Term1Fragment(adapterCallBack);
    }

    @Override
    public int getItemCount() {
        return examItems.length;
    }
}
