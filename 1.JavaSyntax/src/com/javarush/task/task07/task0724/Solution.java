package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandfather1 = new Human("Alex", true, 76);
        Human grandmother1 = new Human("Ally", false, 74);
        Human grandfather2 = new Human("Mike", true, 80);
        Human grandMother2 = new Human("Mary", false, 75);
        Human dad = new Human("George", true, 55, grandMother2, grandfather2);
        Human mom = new Human("Margo", false, 54, grandmother1, grandfather1);
        Human son1 = new Human("Alexander", true, 32, mom, dad);
        Human daughter = new Human("Kate", false, 29, mom, dad);
        Human son2 = new Human("Mike", true, 26, mom, dad);

        System.out.println(grandfather1);
        System.out.println(grandmother1);
        System.out.println(grandfather2);
        System.out.println(grandMother2);
        System.out.println(dad);
        System.out.println(mom);
        System.out.println(son1);
        System.out.println(daughter);
        System.out.println(son2);

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human mother;
        Human father;

        public Human() {
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human mother, Human father) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.mother = mother;
            this.father = father;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















