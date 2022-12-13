package com.example.school_project.examModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Data implements Serializable {
//    @SerializedName("datesheet")
    private List<DateSheet> date_sheet;
    private ExamResult exam_result;

    public ExamResult getExam_result() {
        return exam_result;
    }

    public void setExam_result(ExamResult exam_result) {
        this.exam_result = exam_result;
    }

    public Collection<? extends DateSheet> getDate_sheet() {
        return date_sheet;
    }

    public void setDate_sheet(List<DateSheet> date_sheet) {
        this.date_sheet = date_sheet;
    }
}
