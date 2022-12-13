package com.example.school_project.Alert_Model;

import java.util.List;

public class Data {
    private Alerts alerts;
    private List<Over_Dues> over_dues;
    private List<Calendar> calendar;

    public Alerts getAlerts() {
        return alerts;
    }

    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }

    public List<Over_Dues> getOver_dues() {
        return over_dues;
    }

    public void setOver_dues(List<Over_Dues> over_dues) {
        this.over_dues = over_dues;
    }

    public List<Calendar> getCalendar() {
        return calendar;
    }

    public void setCalendar(List<Calendar> calendar) {
        this.calendar = calendar;
    }
}
