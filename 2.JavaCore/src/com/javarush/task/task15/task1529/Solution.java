package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution  {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        try {
            reset();
        }
        catch (IOException e) {

        }
    }

    public static Flyable result;

    public static void reset() throws IOException{
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String param = "";
        param = reader.readLine();
        if ("helicopter".equals(param))
            result = new Helicopter();
        else if ("plane".equals(param)) {
            int passengers = 0;
                passengers = Integer.parseInt(reader.readLine());
            result = new Plane(passengers);
        }
        reader.close();
    }
}
