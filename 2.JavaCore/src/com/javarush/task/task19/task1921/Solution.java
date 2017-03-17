package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        while (fileReader.ready()) {
            String[] line = fileReader.readLine().split(" ");
            String date = line[line.length - 3] + "/" + line[line.length - 2] + "/" + line[line.length - 1];
            String name = "";
            for (int i = 0; i < line.length - 3; i++) {
                name += line[i] + " ";
            }
            try {
                PEOPLE.add(new Person(name.trim(), dateFormat.parse(date)));
            }
            catch (ParseException e) {}
        }
        fileReader.close();
    }
}
