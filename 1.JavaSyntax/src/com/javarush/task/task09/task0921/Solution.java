package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        List<Integer> numbers = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                int x = Integer.parseInt(reader.readLine());
                numbers.add(x);
            }
        }
        catch (NumberFormatException e) {
            for (Integer i : numbers) {
                System.out.println(i);
            }
        }
        catch (IOException e) {
        }
    }
}
