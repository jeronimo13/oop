package com.ulya.restaurant;

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

        int[] dishCount = new int[restaurant.getMenu().getDishes().length];

        for (int i = 0; i < hermanOrderDishes.length - 1; i++) {
            Dish hermanOrderDish = hermanOrderDishes[i];
            int posInArr = hermanOrderDish.getId();
            int count = dishCount[posInArr];
            count++;
            dishCount[posInArr] = count;
        }

//        for (Dish hermanOrderDish : hermanOrderDishes) {
//            dishCount[hermanOrderDish.getId()] = ++dishCount[hermanOrderDish.getId()];
//        }

        for (Dish ulyaOrderDish : ulyaOrderDishes) {
            dishCount[ulyaOrderDish.getId()] = ++dishCount[ulyaOrderDish.getId()];
        }


        int total = 0;

        System.out.println("Item\t\tquantity\t\tprice");
        for (Dish dish : restaurant.getMenu().getDishes()) {
            int count = dishCount[dish.getId()];
            if (count != 0) {
                int price = count * dish.getPrice();
                System.out.format("%10s%10d%11s", dish.getName(), count, price);
                System.out.println();
                total += price;
            }
        }
        System.out.println("Total\t" + total);


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
        Restaurant restaurant = new Restaurant(createMenu());
        return restaurant;
    }
}
