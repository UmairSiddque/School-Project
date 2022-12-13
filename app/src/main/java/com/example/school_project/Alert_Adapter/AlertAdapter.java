package com.example.school_project.Alert_Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.school_project.Alert_Model.Alerts_Detail;
import com.example.school_project.OverdueActivity;
import com.example.school_project.R;

import java.util.List;

public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.ViewHolder> {
    private final Context context;
    private final List<Alerts_Detail> alertModelList;
    public AlertAdapter(Context context, List<Alerts_Detail> alertModelList) {
        this.context = context;
        this.alertModelList = alertModelList;
    }

    @NonNull
    @Override
    public AlertAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.alertlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlertAdapter.ViewHolder holder, int position) {
Alerts_Detail alertModel=alertModelList.get(position);

        holder.alertTitle.setText(alertModel.getType());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(alertModel.getType().equals("proxy_today")){
                    context.startActivity(new Intent(context, OverdueActivity.class));
                }
            }
        });
        }


    @Override
    public int getItemCount() {
        return alertModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView alertTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            alertTitle=itemView.findViewById(R.id.alertTitleTV);
        }
    }
}
