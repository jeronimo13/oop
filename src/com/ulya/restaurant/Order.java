package com.ulya.restaurant;

public class Order {

    private Position[] positions;
    String name;

    public Order(Position[] positions) {
        this.positions = positions;
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
        for (int i = 0; i < positions.length; i++) {
            price = price + positions[i].getPrice();
        }
        return price;
    }
}
