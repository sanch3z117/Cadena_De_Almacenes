package com.edu.uptc.model;

public class Product {
    private String name;
    private int code;
    private int amount;
    private float unitValue;

    public Product(String name, int code, int amount, float unitValue) {
        this.name = name;
        this.code = code;
        this.amount = amount;
        this.unitValue = unitValue;
    }

    public void updateQuantity(int quantity) {
        this.amount -= quantity;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public int getAmount() {
        return amount;
    }

    public float getUnitValue() {
        return unitValue;
    }

}
