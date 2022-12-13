package com.example.school_project.examAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.school_project.R;
import com.example.school_project.examModel.DateSheet;
import com.example.school_project.examModel.ExamModel;

import java.util.List;

public class DatesheetAdapter extends RecyclerView.Adapter<DatesheetAdapter.ViewHolder> {
    private Context context;
private List<DateSheet> examModelList;

    public DatesheetAdapter(Context context, List<DateSheet> examModelList) {
        this.context = context;
        this.examModelList = examModelList;
    }

    @NonNull
    @Override
    public DatesheetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(context).inflate(R.layout.exam_datesheet_layout,parent,false);
      return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatesheetAdapter.ViewHolder holder, int position) {
DateSheet dateSheet=examModelList.get(position);
holder.datesheetSubj.setText(dateSheet.getType()+"-"+dateSheet.getSub_name());
holder.datesheetDate.setText(dateSheet.getDue_date());
    }

    @Override
    public int getItemCount() {
        return examModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView datesheetDate,datesheetSubj;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            datesheetDate=itemView.findViewById(R.id.examDatesheetDateTV);
            datesheetSubj=itemView.findViewById(R.id.examDatesheetSubjTV);
        }
    }
}
