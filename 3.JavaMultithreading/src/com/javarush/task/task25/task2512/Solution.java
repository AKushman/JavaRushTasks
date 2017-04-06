package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> ts = new ArrayList<>();
        while (e != null) {
            ts.add(e);
            e = e.getCause();
        }
        Collections.reverse(ts);
        for (Throwable twb : ts) {
            System.out.println(twb);
        }
    }

    public static void main(String[] args){

    }
}
