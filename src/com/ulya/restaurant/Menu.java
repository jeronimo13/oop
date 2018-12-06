package com.ulya.restaurant;

import java.util.List;
import java.util.Map;

public class Menu {

    private Map<String, Dish> dishes;


    public Menu(Map<String, Dish> dishes) {
        this.dishes = dishes;
    }

    public Map<String, Dish> getDishes() {
        return dishes;
    }
}
