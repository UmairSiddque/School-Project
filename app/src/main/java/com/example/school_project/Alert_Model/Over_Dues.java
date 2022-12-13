package com.example.school_project.Alert_Model;

public class Over_Dues {
    private String due_date;
    private boolean clickable;
    private String statusArray;
    private String assigned_from;
    private String assigned_date;
    private String type_label;
    private String topic_name;

    public Over_Dues(String due_date, boolean clickable, String statusArray, String assigned_from, String assigned_date, String type_label, String topic_name) {
        this.due_date = due_date;
        this.clickable = clickable;
        this.statusArray = statusArray;
        this.assigned_from = assigned_from;
        this.assigned_date = assigned_date;
        this.type_label = type_label;
        this.topic_name = topic_name;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public String getStatusArray() {
        return statusArray;
    }

    public void setStatusArray(String statusArray) {
        this.statusArray = statusArray;
    }

    public String getAssigned_from() {
        return assigned_from;
    }

    public void setAssigned_from(String assigned_from) {
        this.assigned_from = assigned_from;
    }

    public String getAssigned_date() {
        return assigned_date;
    }

    public void setAssigned_date(String assigned_date) {
        this.assigned_date = assigned_date;
    }

    public String getType_label() {
        return type_label;
    }

    public void setType_label(String type_label) {
        this.type_label = type_label;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }
}
