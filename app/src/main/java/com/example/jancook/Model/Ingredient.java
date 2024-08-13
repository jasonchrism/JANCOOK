package com.example.jancook.Model;

public class Ingredient {
    private String name;
    private String amount;
    private String unit;

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}