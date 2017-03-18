package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        Cat catGrandFather = new Cat(grandFatherName, true);

        String grandMotherName = reader.readLine();
        Cat catGrandMother = new Cat(grandMotherName, false);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, true, catGrandFather);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, false, catGrandMother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, true, catFather, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, false, catFather, catMother);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat father;
        private Cat mother;
        private boolean male;

        Cat(String name, boolean male) {
            this.name = name;
            this.male = male;
        }

        public Cat(String name, boolean male, Cat... parents) {
            this.name = name;
            this.male = male;
            for (int i = 0; i < parents.length; i++) {
                if (parents[i].male)
                    father = parents[i];
                else mother = parents[i];
            }
        }

        @Override
        public String toString() {
            if (mother == null && father == null)
                return "Cat name is " + name + ", no mother, no father";
            else if (mother == null && father != null)
                return "Cat name is " + name + ", no mother, father is  " + father.name;
            else if (father == null && mother != null)
                return "Cat name is " + name + ", mother is  " + mother.name + ", no father";
            else
                return "Cat name is " + name + ", mother is  " + mother.name + ", father is " +father.name;

        }
    }
}
