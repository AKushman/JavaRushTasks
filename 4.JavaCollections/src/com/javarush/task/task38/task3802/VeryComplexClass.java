package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        InputStream stream = new FileInputStream(new File("soomefile"));
    }

    public static void main(String[] args) {

    }
}
