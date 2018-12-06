package com.ulya.restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        Restaurant restaurant = openRestaurant();

        Menu menu = restaurant.getMenu();

        Map<String, Dish> dishes = menu.getDishes();

        List<Dish> hermanOrderDishes = new ArrayList<>();
        hermanOrderDishes.add(dishes.get(Dish.BREAKFAST_NAME));
        List<Dish> ulyaOrderDishes = new ArrayList<>();
        ulyaOrderDishes.add(dishes.get(Dish.LUNCH_NAME));
        ulyaOrderDishes.add(dishes.get(Dish.DINNER_NAME));

        Order hermanOrder = new Order(hermanOrderDishes);
        Order ulyaOrder = new Order(ulyaOrderDishes);


        int hermanOrderPrice = hermanOrder.getPrice();
        int ulyaOrderPrice = ulyaOrder.getPrice();

        int[] hermanDishCount = new int[hermanOrderDishes.size()];

        for (int i = 0; i < hermanOrderDishes.size() - 1; i++) {
            Dish hermanOrderDish = hermanOrderDishes.get(i);
            int posInArr = hermanOrderDish.getId();
            int count = hermanDishCount[posInArr];
            count++;
            hermanDishCount[posInArr] = count;
        }
        int[] ulyaDishCount = new int[hermanOrderDishes.size()];
        for (int i = 0; i < hermanOrderDishes.size() - 1; i++) {
            Dish hermanOrderDish = hermanOrderDishes.get(i);
            int posInArr = hermanOrderDish.getId();
            int count = ulyaDishCount[posInArr];
            count++;
            ulyaDishCount[posInArr] = count;
        }

        int ulyaOrderTotalPrice = 0;
        int hermanOrderTotalPrice = 0;
        for (int i = 0; i < hermanOrderDishes.size(); i++) {
           int hermanOrderPriceOfDish = hermanOrderDishes.get(i).getPrice() * hermanDishCount[i];
            hermanOrderTotalPrice = +hermanOrderPriceOfDish;
        }
        for (int i = 0; i < ulyaOrderDishes.size(); i++) {
            int ulyaOrderPriceOfDish = ulyaOrderDishes.get(i).getPrice() * ulyaDishCount[i];
            ulyaOrderTotalPrice = +ulyaOrderPriceOfDish;
        }
        int totalPriceOfOrder = hermanOrderTotalPrice + ulyaOrderTotalPrice;
        System.out.println("Herman to pay: " + hermanOrderPrice);
        System.out.println("Ulya to pay: " + ulyaOrderPrice);

    }


    static Menu createMenu() {
        Food breakfast = new Food(100, Dish.BREAKFAST_NAME, 0);
        Food lunch = new Food(120, Dish.LUNCH_NAME, 1);
        Food dinner = new Food(90, Dish.DINNER_NAME, 2);


        Drink coffee = new Drink("Coffee", 10, 3);
        Drink tea = new Drink("Tea", 9, 4);
        Drink vodka = new Drink("Vodka", 50, 5);

//        List<Dish> dishes = new ArrayList<>();
//        dishes.add(breakfast);
//        dishes.add(lunch);
//        dishes.add(dinner);
//        dishes.add(coffee);
//        dishes.add(tea);
//        dishes.add(vodka);

        Map<String, Dish> dishes = new HashMap<String, Dish>();
        dishes.put(breakfast.getName(), breakfast);
        dishes.put(lunch.getName(), lunch);
        dishes.put(dinner.getName(), dinner);
        dishes.put(coffee.getName(), coffee);
        dishes.put(tea.getName(), tea);
        dishes.put(vodka.getName(), vodka);


        return new Menu(dishes);
    }

    static Restaurant openRestaurant() {
        return new Restaurant(createMenu());
    }
}
