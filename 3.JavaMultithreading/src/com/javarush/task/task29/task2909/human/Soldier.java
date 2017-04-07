package com.javarush.task.task29.task2909.human;

/**
 * Created by ext_akushman on 06.04.2017.
 */
public class Soldier extends Human implements Alive{


    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
        fight();
    }

    public void fight() {
    }
}
