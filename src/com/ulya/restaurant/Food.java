package com.ulya.restaurant;


public class Food implements Dish {


    private int price;
    private String name;
    private int id;

    public Food(int price, String name, int id) {
        this.price = price;
        this.name = name;
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
        System.out.println("You've just ate " + name);
    }

    @Override
    public int getId(){
        return id;
    }
}
