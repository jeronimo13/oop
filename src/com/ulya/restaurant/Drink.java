package com.ulya.restaurant;

public class Drink implements Dish {

    private String name;
    private int price;
    private int id;


    public Drink(String name, int price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
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

    @Override
    public int getId(){
        return id;
    }
}
