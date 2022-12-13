package com.example.school_project.examModel;

public class ExamModel {
    private String subjName;
    private String monthlyMarks;
    private String terminalMarks;
    private int subjIV;
    private String examDate;
    private String examSubject;
    private String downloadResults;
    private String status;
    private String monthlyTotalMarksObt,monthlyTotalMarks,terminalTotalMarksObt,terminalTotalMarks;
    private String monthlyPercentage,terminalPercentage;

    public ExamModel(String monthlyTotalMarksObt, String monthlyTotalMarks, String terminalTotalMarksObt, String terminalTotalMarks, String monthlyPercentage, String terminalPercentage) {
        this.monthlyTotalMarksObt = monthlyTotalMarksObt;
        this.monthlyTotalMarks = monthlyTotalMarks;
        this.terminalTotalMarksObt = terminalTotalMarksObt;
        this.terminalTotalMarks = terminalTotalMarks;
        this.monthlyPercentage = monthlyPercentage;
        this.terminalPercentage = terminalPercentage;
    }

    private int downloadResultsIV;

    public ExamModel(String downloadResults, int downloadResultsIV) {
        this.downloadResults = downloadResults;
        this.downloadResultsIV = downloadResultsIV;
    }

    public String getMonthlyTotalMarksObt() {
        return monthlyTotalMarksObt;
    }

    public void setMonthlyTotalMarksObt(String monthlyTotalMarksObt) {
        this.monthlyTotalMarksObt = monthlyTotalMarksObt;
    }

    public String getMonthlyTotalMarks() {
        return monthlyTotalMarks;
    }

    public void setMonthlyTotalMarks(String monthlyTotalMarks) {
        this.monthlyTotalMarks = monthlyTotalMarks;
    }

    public String getTerminalTotalMarksObt() {
        return terminalTotalMarksObt;
    }

    public void setTerminalTotalMarksObt(String terminalTotalMarksObt) {
        this.terminalTotalMarksObt = terminalTotalMarksObt;
    }

    public String getTerminalTotalMarks() {
        return terminalTotalMarks;
    }

    public void setTerminalTotalMarks(String terminalTotalMarks) {
        this.terminalTotalMarks = terminalTotalMarks;
    }

    public String getMonthlyPercentage() {
        return monthlyPercentage;
    }

    public void setMonthlyPercentage(String monthlyPercentage) {
        this.monthlyPercentage = monthlyPercentage;
    }

    public String getTerminalPercentage() {
        return terminalPercentage;
    }

    public void setTerminalPercentage(String terminalPercentage) {
        this.terminalPercentage = terminalPercentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDownloadResultsIV() {
        return downloadResultsIV;
    }

    public void setDownloadResultsIV(int downloadResultsIV) {
        this.downloadResultsIV = downloadResultsIV;
    }

    public String getDownloadResults() {
        return downloadResults;
    }

    public void setDownloadResults(String downloadResults) {
        this.downloadResults = downloadResults;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamSubject() {
        return examSubject;
    }

    public void setExamSubject(String examSubject) {
        this.examSubject = examSubject;
    }

    public int getSubjIV() {
        return subjIV;
    }

    public void setSubjIV(int subjIV) {
        this.subjIV = subjIV;
    }

    public String getSubjName() {
        return subjName;
    }

    public void setSubjName(String subjName) {
        this.subjName = subjName;
    }

    public String getMonthlyMarks() {
        return monthlyMarks;
    }

    public void setMonthlyMarks(String monthlyMarks) {
        this.monthlyMarks = monthlyMarks;
    }

    public String getTerminalMarks() {
        return terminalMarks;
    }

    public void setTerminalMarks(String terminalMarks) {
        this.terminalMarks = terminalMarks;
    }
}
