package com.javarush.task.task16.task1632;

/**
 * Created by Alexander on 12.03.2017.
 */
public class Warning extends Thread implements Message {
    @Override
    public void run() {

    }

    @Override
    public void showWarning() {
        this.interrupt();
    }
}
