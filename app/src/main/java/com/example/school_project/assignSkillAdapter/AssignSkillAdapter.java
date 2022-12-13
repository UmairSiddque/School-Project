package com.example.school_project.assignSkillAdapter;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.school_project.R;
import com.example.school_project.assignSkillModel.AssignSkillModel;

import java.util.Calendar;
import java.util.List;

public class AssignSkillAdapter extends RecyclerView.Adapter<AssignSkillAdapter.ViewHolder> {
    private Context context;
    private List<AssignSkillModel> assignSkillModelList;
    private DatePickerDialog datePickerDialog;
    public AssignSkillAdapter(Context context, List<AssignSkillModel> assignSkillModelList) {
        this.context = context;
        this.assignSkillModelList = assignSkillModelList;
    }

    @NonNull
    @Override
    public AssignSkillAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.assignskilllayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignSkillAdapter.ViewHolder holder, int position) {
        holder.textView.setText(assignSkillModelList.get(position).getName());
        holder.datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener dataSetListener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month=month+1;
                        String data=makeDataString(day,month,year);
                        holder.datePickerButton.setText(data);
                    }
                };
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                datePickerDialog=new DatePickerDialog(context,R.style.DatePickerDialog,dataSetListener,year,month,day);
//                datePickerDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setBackgroundColor(Color.parseColor("#E9454545"));
                datePickerDialog.show();
                datePickerDialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(context.getResources().getColor(R.color.completed_color));
                datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(context.getResources().getColor(R.color.completed_color));
                openDatePicker(view);
            }
        });
    }


    @Override
    public int getItemCount() {
        return assignSkillModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
private Button datePickerButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.assignSkillTV);
            datePickerButton=itemView.findViewById(R.id.assignDatePickerButton);
        }
    }
    private String makeDataString(int day,int month,int year){
        return getMonthFormat(month) +"  "+day+"  "+year;
    }
    private String getMonthFormat(int month){
        if(month==1){
            return"JAN";
        }
        if(month==2){
            return"FEB";
        }
        if(month==3){
            return"MAR";
        }
        if(month==4){
            return"APR";
        }
        if(month==5){
            return"MAY";
        }
        if(month==6){
            return"JUN";
        }
        if(month==7){
            return"JUL";
        }
        if(month==8){
            return"AUG";
        }
        if(month==9){
            return"SEP";
        }
        if(month==10){
            return"OCT";
        }
        if(month==11){
            return"NOV";
        }
        if(month==12){
            return"DEC";
        }
        return "JAN";
    }
    private void openDatePicker(View view) {
        datePickerDialog.show();
    }
}
