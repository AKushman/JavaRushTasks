package com.javarush.task.task16.task1632;

/**
 * Created by Alexander on 12.03.2017.
 */
public class Interrupted extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1);
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}
