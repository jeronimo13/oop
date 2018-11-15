package com.ulya.restaurant;

public class Menu {

    private Dish[] dishes;


    public Menu(Dish[] dishes) {
        this.dishes = dishes;
    }

    public Dish[] getDishes() {
        return dishes;
    }
}
