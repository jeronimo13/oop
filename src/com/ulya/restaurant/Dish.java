package com.ulya.restaurant;

public interface Dish {

    public final String BREAKFAST_NAME = "Breakfast";
    public final String LUNCH_NAME = "Lunch";
    public final String DINNER_NAME = "Dinner";

    int getPrice();

    int getId();

    String getName();

    void consume();
}
