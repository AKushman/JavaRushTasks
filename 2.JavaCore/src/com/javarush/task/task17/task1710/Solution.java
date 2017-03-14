package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1

    }

    public static void main(String[] args) {
        //start here - начни тут
        if ("-c".equals(args[0]))
            create(args[1], args[2], args[3]);
        if ("-u".equals(args[0]))
            update(args[1], args[2], args[3], args[4]);
        if ("-d".equals(args[0]))
            delete(args[1]);
        if ("-i".equals(args[0]))
            info(args[1]);

    }

    public static void create(String name, String sex, String bd) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = dateFormat.parse(bd);
        }
        catch (ParseException ex) {

        }
        if ("м".equals(sex))
            allPeople.add(Person.createMale(name, date));
        else allPeople.add(Person.createFemale(name, date));
        System.out.println(allPeople.size() - 1);
    }

    public static void update(String id, String name, String sex, String bd) {
        int index = Integer.parseInt(id);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = dateFormat.parse(bd);
        }
        catch (ParseException ex) {

        }
        Sex sexUpdate;
        if ("м".equals(sex))
            sexUpdate = Sex.MALE;
        else sexUpdate = Sex.FEMALE;
        Person person = allPeople.get(index);
        person.setName(name);
        person.setSex(sexUpdate);
        person.setBirthDay(date);
        allPeople.set(index, person);
    }

    public static void delete(String id) {
        int index = Integer.parseInt(id);
        Person person = allPeople.get(index);
        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);
        allPeople.set(index, person);
    }

    public static void info(String id) {
        Person person = allPeople.get(Integer.parseInt(id));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println(person.getName() + " " + (person.getSex().equals(Sex.MALE) ? "м" : "ж") + " " + dateFormat.format(person.getBirthDay()));
    }

}
