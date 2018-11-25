package com.ulya.restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Restaurant restaurant = openRestaurant();

        Menu menu = restaurant.getMenu();

        List<Dish> dishes = menu.getDishes();


        List<Dish> hermanOrderDishes = new ArrayList<>();
        hermanOrderDishes.add(dishes.get(0));
        hermanOrderDishes.add(dishes.get(3));
        List<Dish> ulyaOrderDishes = new ArrayList<>();
        ulyaOrderDishes.add(dishes.get(1));
        ulyaOrderDishes.add(dishes.get(4));
        ulyaOrderDishes.add(dishes.get(3));

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

        List<Dish> dishes = new ArrayList<>();
        dishes.add(breakfast);
        dishes.add(lunch);
        dishes.add(dinner);
        dishes.add(coffee);
        dishes.add(tea);
        dishes.add(vodka);

        return new Menu(dishes);
    }

    static Restaurant openRestaurant() {
        return new Restaurant(createMenu());
    }
}
