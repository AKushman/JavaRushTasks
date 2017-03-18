package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);

        //напишите тут ваш код

        Dog butchDog = new Dog("Butch", 35, 2);
        Cat tomCat = new Cat("Tom", 17, 1);
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //напишите тут ваш код

    public static class Dog {
        String name;
        int weight;
        int height;

        public Dog(String name, int weight, int height) {
            this.name = name;
            this.weight = weight;
            this.height = height;
        }
    }

    public static class Cat {
        String name;
        int speed;
        int height;

        public Cat(String name, int speed, int height) {
            this.name = name;
            this.speed = speed;
            this.height = height;
        }
    }
}
