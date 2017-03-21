package com.javarush.task.task20.task2024;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.reset();
    }

    public static void main(String[] args) {

    }
}
