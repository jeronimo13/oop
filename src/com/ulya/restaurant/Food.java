package com.ulya.restaurant;


public class Food implements Position {


    private int price;
    private String name;

    public Food(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void consume() {
        System.out.println("You've just ate " + name);
    }
}
