package com.ulya.restaurant;

public class Order {

    private Dish[] dishes;
    String name;

    public Order(Dish[] dishes) {
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
        for (int i = 0; i < dishes.length; i++) {
            price = price + dishes[i].getPrice();
        }
        return price;
    }
}
