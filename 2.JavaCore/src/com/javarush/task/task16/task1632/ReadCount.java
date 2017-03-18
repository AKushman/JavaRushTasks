package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadCount extends Thread {
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        int counter = 0;
        while (true) {
            try {
                s = reader.readLine();
            }
            catch (IOException e) {

            }
            if("N".equals(s))
                break;
            else
                counter += Integer.parseInt(s);
        }
        System.out.println(counter);
    }
}
