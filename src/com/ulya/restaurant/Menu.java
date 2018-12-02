package com.ulya.restaurant;

import java.util.List;

public class Menu {

    private List<Dish> dishes;


    public Menu(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
