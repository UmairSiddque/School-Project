package com.example.school_project.examModel;

public class T1 {
    private String subject_name;
    private int monthly_total_marks;
    private int monthly_obtained_marks;
    private int terminal_obtained_marks;
    private int terminal_total_marks;
private int imageResource;
private String status;

    public T1(String subject_name, int monthly_total_marks, int monthly_obtained_marks, int terminal_obtained_marks, int terminal_total_marks) {
        this.subject_name = subject_name;
        this.monthly_total_marks = monthly_total_marks;
        this.monthly_obtained_marks = monthly_obtained_marks;
        this.terminal_obtained_marks = terminal_obtained_marks;
        this.terminal_total_marks = terminal_total_marks;
    }

    public T1(String subject_name, int monthly_total_marks) {
        this.subject_name = subject_name;
        this.monthly_total_marks = monthly_total_marks;
        this.monthly_obtained_marks = monthly_obtained_marks;
        this.terminal_obtained_marks = terminal_obtained_marks;
        this.terminal_total_marks = terminal_total_marks;
        this.imageResource = imageResource;
    }

    public String getStatus() {
        return status;
    }

    public String setStatus(String status) {
        this.status = status;
        return status;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getMonthly_total_marks() {
        return monthly_total_marks;
    }

    public void setMonthly_total_marks(int monthly_total_marks) {
        this.monthly_total_marks = monthly_total_marks;
    }

    public int getMonthly_obtained_marks() {
        return monthly_obtained_marks;
    }

    public void setMonthly_obtained_marks(int monthly_obtained_marks) {
        this.monthly_obtained_marks = monthly_obtained_marks;
    }

    public int getTerminal_obtained_marks() {
        return terminal_obtained_marks;
    }

    public void setTerminal_obtained_marks(int terminal_obtained_marks) {
        this.terminal_obtained_marks = terminal_obtained_marks;
    }

    public int getTerminal_total_marks() {
        return terminal_total_marks;
    }

    public void setTerminal_total_marks(int terminal_total_marks) {
        this.terminal_total_marks = terminal_total_marks;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
