package com.ulya.restaurant;

public class Drink implements Position {



    private String name;
    private int price;


    public Drink(String name, int price) {
        this.name = name;
        this.price = price;
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
        System.out.println("You've just drunk " + name);
    }
}
