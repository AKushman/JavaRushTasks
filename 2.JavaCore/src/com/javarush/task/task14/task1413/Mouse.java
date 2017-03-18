package com.javarush.task.task14.task1413;

/**
 * Created by Alexander on 04.03.2017.
 */
public class Mouse implements CompItem {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
