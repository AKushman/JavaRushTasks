package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем Singleton pattern
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
         readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String param = null;
        try {
           param = reader.readLine();
        }
        catch (IOException e) {

        }
        if (Planet.EARTH.equals(param))
            thePlanet = Earth.getInstance();
        else if (Planet.MOON.equals(param))
            thePlanet = Moon.getInstance();
        else if (Planet.SUN.equals(param))
            thePlanet = Sun.getInstance();
        else thePlanet = null;
    }
}
