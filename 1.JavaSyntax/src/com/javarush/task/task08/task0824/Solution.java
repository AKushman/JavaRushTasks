package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human garndfather1 = new Human("grandfather_1", true, 75);
        Human grandfather2 = new Human("grandfather_2", true, 77);
        Human grandmother1 = new Human("grandmother_1", false, 74);
        Human grandmother2 = new Human("grandmother_1", false, 75);
        Human father = new Human("father", true, 52);
        Human mother = new Human("mother", false, 50);
        Human child1 = new Human("child_1", true, 33);
        Human child2 = new Human("child_2", false, 30);
        Human child3 = new Human("child_3", true, 27);
        garndfather1.children.add(father);
        grandmother1.children.add(father);
        grandfather2.children.add(mother);
        grandmother2.children.add(mother);
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);
        System.out.println(garndfather1);
        System.out.println(grandmother1);
        System.out.println(grandfather2);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
