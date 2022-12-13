package com.example.school_project.homeAdapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.school_project.Challenges.MainActivity;
import com.example.school_project.R;
import com.example.school_project.homeActivities.BottomPopUpFragment;
import com.example.school_project.homeActivities.HomeActivity;
import com.example.school_project.homeModel.DataArray;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
    private List<DataArray> dataArrayList;

    public HomeAdapter(Context context, List<DataArray> dataArrayList) {
        this.context = context;
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(context).inflate(R.layout.home_layout,parent,false);
    return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
DataArray dataArray=dataArrayList.get(position);
holder.homeTitle.setText(dataArray.getTitle());
holder.homeDesc.setText(dataArray.getDescription());
holder.homeDate.setText(dataArray.getDate());
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        BottomPopUpFragment bottomPopUpFragment=new BottomPopUpFragment();
        bottomPopUpFragment.show(((AppCompatActivity)context).getSupportFragmentManager(),bottomPopUpFragment.getTag());
        SharedPreferences sharedPreferences= context.getSharedPreferences("myKey",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("title",dataArray.getTitle());
        editor.putString("description",dataArray.getDescription());
        editor.apply();
    }
});
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView homeTitle,homeDate,homeDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            homeTitle=itemView.findViewById(R.id.homeTitleTV);
            homeDate=itemView.findViewById(R.id.homeDateTV);
            homeDesc=itemView.findViewById(R.id.homeDescTV);
        }
    }

}
