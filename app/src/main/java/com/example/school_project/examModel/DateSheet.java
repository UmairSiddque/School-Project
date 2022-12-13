package com.example.school_project.examModel;

public class DateSheet {
    private String sub_name;
    private String due_date;
    private String type;

    public DateSheet(String sub_name, String due_date, String type) {
        this.sub_name = sub_name;
        this.due_date = due_date;
        this.type = type;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
