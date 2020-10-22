package com.eci.cosw.springbootsecureapi.model;

public class Task {

    private int id;
    private String text;
    private String responsible;
    private String dueDate;
    private String status;

    public Task(int id, String text, String responsible, String dueDate, String status) {
        this.id = id;
        this.text = text;
        this.responsible = responsible;
        this.dueDate = dueDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
