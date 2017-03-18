package com.javarush.task.task16.task1632;

/**
 * Created by Alexander on 12.03.2017.
 */
public class Hooray extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Ура");
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {}
        }
    }
}
