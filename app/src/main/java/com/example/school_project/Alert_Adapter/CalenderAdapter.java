package com.example.school_project.Alert_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.school_project.Alert_Model.Calendar;
import com.example.school_project.R;

import java.util.List;

public class CalenderAdapter extends RecyclerView.Adapter<CalenderAdapter.ViewHolder> {
    private final Context context;
    private final List<Calendar> alertModels;
    public CalenderAdapter(Context context, List<Calendar> alertModels) {
        this.context = context;
        this.alertModels = alertModels;
    }

    @NonNull
    @Override
    public CalenderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.calanderlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalenderAdapter.ViewHolder holder, int position) {

        holder.dueDate.setText(alertModels.get(position).getDue_date());
        holder.taskTitle.setText(alertModels.get(position).getType_label()+alertModels.get(position).getTopic_name());
        if(alertModels.get(position).isClickable()){
            Glide.with(context).load(R.drawable.redflag).into(holder.overdueIV);
        }
        else{
            Glide.with(context).load(R.drawable.home).into(holder.overdueIV);
        }
    }
    @Override
    public int getItemCount() {
        return alertModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView dueDate;
        private final TextView taskTitle;
        private final ImageView overdueIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dueDate=itemView.findViewById(R.id.calanderDate);
            taskTitle=itemView.findViewById(R.id.calanderTaskTitle);
            overdueIV=itemView.findViewById(R.id.calanderIV);
        }
    }
}
