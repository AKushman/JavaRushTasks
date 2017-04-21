package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        DirectorTablet directorTablet = new DirectorTablet();
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Chief");
        Waiter waiter = new Waiter();
        tablet.addObserver(cook);
        cook.addObserver(waiter);
        tablet.createOrder();

        Tablet tablet2 = new Tablet(2);
        Cook cook2 = new Cook("SuChief");
        tablet2.addObserver(cook2);
        cook2.addObserver(waiter);
        tablet2.createOrder();


        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
