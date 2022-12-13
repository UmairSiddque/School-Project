package com.example.school_project.Model;

public class Pojo {
    private String title;
    private String subject;
    private String completed_status;
    public int imageRes;
    private int completed_levels;
    private int rank;
    private int game_levels;

    public Pojo(String title, String subject, String completed_status, int imageRes, int completed_levels, int rank, int game_levels) {
        this.title = title;
        this.subject = subject;
        this.completed_status = completed_status;
        this.imageRes = imageRes;
        this.completed_levels = completed_levels;
        this.rank = rank;
        this.game_levels = game_levels;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCompleted_status() {
        return completed_status;
    }

    public void setCompleted_status(String completed_status) {
        this.completed_status = completed_status;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public int getCompleted_levels() {
        return completed_levels;
    }

    public void setCompleted_levels(int completed_levels) {
        this.completed_levels = completed_levels;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getGame_levels() {
        return game_levels;
    }

    public void setGame_levels(int game_levels) {
        this.game_levels = game_levels;
    }
}


