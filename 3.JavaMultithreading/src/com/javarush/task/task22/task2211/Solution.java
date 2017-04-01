package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        Charset win1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);
        while (fileReader.ready()) {
            byte[] buffer = fileReader.readLine().getBytes(win1251);
            String s = new String(buffer, utf8);
            fileWriter.write(s);
        }
        fileReader.close();
        fileWriter.close();
    }
}
