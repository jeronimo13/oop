package com.ulya.restaurant;

public class Main {


    public static void main(String[] args) {
        Restaurant restaurant = openRestaurant();

        Menu menu = restaurant.getMenu();

        Position[] positions = menu.getPositions();


        Position[] hermanOrderPositions = {positions[0], positions[3]};
        Position[] ulyaOrderPositions = {positions[1], positions[4]};

        Order hermanOrder = new Order(hermanOrderPositions);
        Order ulyaOrder = new Order(ulyaOrderPositions);



        int hermanOrderPrice = hermanOrder.getPrice();
        int ulyaOrderPrice = ulyaOrder.getPrice();

        System.out.println("Herman to pay: "+ hermanOrderPrice);
        System.out.println("Ulya to pay: "+ ulyaOrderPrice);
//        System.out.println(hermanOrder.equals(ulyaOrder));


    }



    static Menu createMenu (){
        Food breakfast = new Food(100, "Breakfast");
        Food lunch = new Food(120, "Lunch");
        Food dinner = new Food(90, "Dinner");


        Drink coffee = new Drink("Coffee", 10);
        Drink tea = new Drink("Tea", 9);
        Drink vodka = new Drink("Vodka", 50);

        Position[] positions = {breakfast, lunch, dinner, coffee, tea, vodka};

        Menu menu = new Menu(positions);

        return menu;
    }

    static Restaurant openRestaurant(){
        Restaurant restaurant = new Restaurant(createMenu());
        return restaurant;
    }
}
