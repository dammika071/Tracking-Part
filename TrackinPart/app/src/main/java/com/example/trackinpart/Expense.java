package com.example.trackinpart;

public class Expense {
    private long id;
    private double amount;
    private String type;
    private String note;
    private String category;

    public Expense() {
    }

    public Expense(double amount, String type, String note, String category) {
        this.amount = amount;
        this.type = type;
        this.note = note;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
