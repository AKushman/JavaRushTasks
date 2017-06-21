package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {

    private CurrencyManipulatorFactory() {
    }

    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        CurrencyManipulator manipulator = map.get(currencyCode.toUpperCase());
        if (manipulator == null) {
            map.put(currencyCode.toUpperCase(), new CurrencyManipulator(currencyCode.toUpperCase()));
            manipulator = map.get(currencyCode.toUpperCase());
        }
        return manipulator;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
