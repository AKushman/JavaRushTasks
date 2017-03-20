package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        Solution solution = new Solution(25);
        System.out.println(new Solution(4));
        String file = "/home/user/GIT/first";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            System.out.println(solution);
            outputStream.writeObject(solution);
        }
        catch (IOException ex) { }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            Solution loaded = (Solution) inputStream.readObject();
            System.out.println(loaded);
        }
        catch (IOException ex) {}
        catch (ClassNotFoundException e) {}

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
