package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String[] peronData = fileScanner.nextLine().split(" ");
            String personFirstName = peronData[1];
            String personLastName = peronData[0];
            String personMiddleName = peronData[2];
            Date personBirthday = null;
            try {
                personBirthday = new SimpleDateFormat("dd MM yyyy").parse(String.format("%s %s %s", peronData[3], peronData[4], peronData[5]));
            }
            catch (ParseException e) {}
            Person person = new Person(personFirstName, personMiddleName, personLastName, personBirthday);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
