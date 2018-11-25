package com.ulya.restaurant;

import java.util.List;

public class Order {

    private List<Dish> dishes;
    String name;

    public Order(List<Dish> dishes) {
        this.dishes = dishes;
    }

//
//    public Order(){
//    }
//
//
//    public Order contructor(){
//        Order order = new Order();
//        return order;
//    }


    public int getPrice() {
        int price = 0;
        for (Dish dish : dishes) {
            price += dish.getPrice();
        }
        return price;
    }
}
