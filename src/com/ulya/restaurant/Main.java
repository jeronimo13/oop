package com.ulya.restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Restaurant restaurant = openRestaurant();

        Menu menu = restaurant.getMenu();

        Dish[] dishes = menu.getDishes();


        Dish[] hermanOrderDishes = {dishes[0], dishes[3]};
        Dish[] ulyaOrderDishes = {dishes[1], dishes[4], dishes[3]};

        Order hermanOrder = new Order(hermanOrderDishes);
        Order ulyaOrder = new Order(ulyaOrderDishes);


        int hermanOrderPrice = hermanOrder.getPrice();
        int ulyaOrderPrice = ulyaOrder.getPrice();

        System.out.println("Herman to pay: " + hermanOrderPrice);
        System.out.println("Ulya to pay: " + ulyaOrderPrice);

    }


    static Menu createMenu() {
        Food breakfast = new Food(100, "Breakfast", 0);
        Food lunch = new Food(120, "Lunch", 1);
        Food dinner = new Food(90, "Dinner", 2);


        Drink coffee = new Drink("Coffee", 10, 3);
        Drink tea = new Drink("Tea", 9, 4);
        Drink vodka = new Drink("Vodka", 50, 5);

        Dish[] dishes = {breakfast, lunch, dinner, coffee, tea, vodka};

        Menu menu = new Menu(dishes);

        return menu;
    }

    static Restaurant openRestaurant() {
        return new Restaurant(createMenu());
    }
}
