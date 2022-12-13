package com.example.school_project.examAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.school_project.R;
import com.example.school_project.examActivities.ExamActivity;
import com.example.school_project.examModel.T1;
import java.util.List;

public class Term1Adapter extends RecyclerView.Adapter<Term1Adapter.ViewHolder>  {
    private final Context context;
    private final List<T1> t1List;
    private AdapterCallBack adapterCallBack;
int[] imageRes =new int[]{R.drawable.english,R.drawable.urdu,R.drawable.english,R.drawable.islamiyat,R.drawable.mathmatics,R.drawable.english,R.drawable.english,R.drawable.urdu};
    public Term1Adapter(Context context, List<T1> t1List,AdapterCallBack adapterCallBack) {
        this.context = context;
        this.t1List = t1List;
        this.adapterCallBack=adapterCallBack;
    }

    public Term1Adapter(Context context, List<T1> t1List) {
        this.context = context;
        this.t1List = t1List;
    }

    @NonNull
    @Override
    public Term1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.exam_sub_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Term1Adapter.ViewHolder holder, int position) {
        T1 t1 = t1List.get(position);
        holder.examSubjName.setText(t1.getSubject_name());
        holder.examMonthlyMarks.setText(t1.getMonthly_obtained_marks() + "/" + t1.getMonthly_total_marks());
        holder.examTerminalMarks.setText(t1.getTerminal_obtained_marks() + "/" + t1.getTerminal_total_marks());
        Glide.with(context).load(imageRes[position]).into(holder.examSubjIV);
    }
    @Override
    public int getItemCount() {
        return t1List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView examSubjName,examMonthlyMarks,examTerminalMarks;
        private ImageView examSubjIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            examSubjName=itemView.findViewById(R.id.examSubjName);
            examMonthlyMarks=itemView.findViewById(R.id.examMonthlyMarks);
            examTerminalMarks=itemView.findViewById(R.id.examTerminalMarks);
            examSubjIV=itemView.findViewById(R.id.examSubjIV);
        }
    }
   public interface AdapterCallBack{
void switchTabs(String value);
    }
}
