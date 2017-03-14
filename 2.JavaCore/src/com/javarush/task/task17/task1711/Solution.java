package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c" :
                synchronized (allPeople) {
                    create(args);
                    break;
                }
            case "-u" :
                synchronized (allPeople) {
                    update(args);
                    break;
                }
            case "-d" :
                synchronized (allPeople) {
                    delete(args);
                    break;
                }
            case "-i" :
                synchronized (allPeople) {
                    info(args);
                    break;
                }
        }

    }

    public static void create(String[] people) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;
        int steps = (people.length - 1) / 3;
        for (int i = 0; i < steps; i++) {
            try {
                date = dateFormat.parse(people[1 + i*3 + 2]);
            }
            catch (ParseException ex) {

            }
            if ("м".equals(people[1 + i*3 + 1]))
                allPeople.add(Person.createMale(people[1 + i*3], date));
            else allPeople.add(Person.createFemale(people[1 + i*3], date));
            System.out.println(allPeople.size() - 1);
        }

    }

    public static void update(String[] people) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;
        int steps = (people.length - 1) / 4;
        for (int i = 0; i < steps; i++) {
            int index = Integer.parseInt(people[1 + i*4]);
            try {
                date = dateFormat.parse(people[1 + i*4 + 3]);
            }
            catch (ParseException ex) {

            }
            Sex sexUpdate;
            if ("м".equals(people[1 + i*4 + 2]))
                sexUpdate = Sex.MALE;
            else sexUpdate = Sex.FEMALE;
            Person person = allPeople.get(index);
            person.setName(people[1 + i*4 + 1]);
            person.setSex(sexUpdate);
            person.setBirthDay(date);
            allPeople.set(index, person);
        }
    }

    public static void delete(String[] people) {
        for (int i = 1; i < people.length; i++) {
            int index = Integer.parseInt(people[i]);
            Person person = allPeople.get(index);
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
            allPeople.set(index, person);
        }
    }

    public static void info(String[] people) {
        for (int i = 1; i < people.length; i++) {
            int index = Integer.parseInt(people[i]);
            Person person = allPeople.get(index);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(person.getName() + " " + (person.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + dateFormat.format(person.getBirthDay()));
        }
    }
}
