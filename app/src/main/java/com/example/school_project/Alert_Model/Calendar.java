package com.example.school_project.Alert_Model;

public class Calendar {
    private String due_date;
    private boolean clickable;
    private String type_label;
    private String topic_name;

    public Calendar(String due_date, boolean clickable, String type_label, String topic_name) {
        this.due_date = due_date;
        this.clickable = clickable;
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
