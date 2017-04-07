package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;
    private final String SOME_TEXT = "Some text for %d";

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            int key = 1;
            while (true) {
                map.put(String.valueOf(key), String.format(SOME_TEXT, key));
                key++;
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
