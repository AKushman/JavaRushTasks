package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String s : strings) {
            result.add(shortener.getId(s));
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long l : keys) {
            result.add(shortener.getString(l));
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            testSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Date startTime = new Date();
        Set<Long> ids = getIds(shortener, testSet);
        Date stopTime = new Date();
        Helper.printMessage(String.valueOf(stopTime.getTime() - startTime.getTime()));
        startTime = new Date();
        Set<String> strings = getStrings(shortener, ids);
        stopTime = new Date();
        Helper.printMessage(String.valueOf(stopTime.getTime() - startTime.getTime()));
        if (testSet.equals(strings))
            Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
    }
}
