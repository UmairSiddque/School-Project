package com.example.school_project.Alert_Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.school_project.Alert_Model.Over_Dues;
import com.example.school_project.R;
import com.example.school_project.TaskCompleteActivity;
import com.example.school_project.TaskPendingActivity;

import java.util.List;

public class OverdueAdapter extends RecyclerView.Adapter<OverdueAdapter.ViewHolder> {
    private Context context;
    private List<Over_Dues> over_duesList;

    public OverdueAdapter(Context context, List<Over_Dues> over_duesList) {
        this.context = context;
        this.over_duesList = over_duesList;
    }

    private String[] statusArray=new String[]{"pending","complete"};
    @NonNull
    @Override
    public OverdueAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.overduelayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OverdueAdapter.ViewHolder holder, int position) {
Over_Dues over_dues=over_duesList.get(position);
holder.dueDate.setText(over_dues.getDue_date());
holder.taskTitle.setText(over_dues.getType_label()+"-"+over_dues.getAssigned_from()+"-"+over_dues.getTopic_name());
if(over_dues.isClickable()){
    Glide.with(context).load(R.drawable.redflag).into(holder.overdueIV);
}
else {
    Glide.with(context).load(R.drawable.home).into(holder.overdueIV);
}
if (statusArray[position].equals("pending")){
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, TaskPendingActivity.class);
                intent.putExtra("assignedFrom", over_dues.getAssigned_from());
                intent.putExtra("dueDate", over_dues.getDue_date());
                intent.putExtra("assignedDate", over_dues.getAssigned_date());
                intent.putExtra("status", "pending");
            context.startActivity(intent);
        }
    });

}
else {
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(context, TaskCompleteActivity.class);
            intent.putExtra("assignedFrom", over_dues.getAssigned_from());
            intent.putExtra("dueDate", over_dues.getDue_date());
            intent.putExtra("assignedDate", over_dues.getAssigned_date());
            intent.putExtra("status", "complete");
            context.startActivity(intent);
        }
    });

}
    }

    @Override
    public int getItemCount() {
        return over_duesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView dueDate;
        private final TextView taskTitle;
        private final ImageView overdueIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dueDate=itemView.findViewById(R.id.overdueDate);
            taskTitle=itemView.findViewById(R.id.overdueTaskTitle);
            overdueIV=itemView.findViewById(R.id.overdueIV);
        }
    }
}
