package com.example.school_project.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.school_project.Challenges.All_Challenges_Fragment;
import com.example.school_project.Challenges.For_You_Fragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    String[] items=new String[]{"For you", "All Challenges"};
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new For_You_Fragment();
            case 1:
                return new All_Challenges_Fragment();
        }
        return new For_You_Fragment();
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
