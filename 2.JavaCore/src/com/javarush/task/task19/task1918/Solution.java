package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

/*
Хотя гораздо удобнее использовать вместо метода separateTag библиотеку Jsoup, код прилагается:

Document doc = Jsoup.parse(fileContent);
Elements elements = doc.getElementsByTag(args[0]);
Element e: elements) {
    System.out.println(e);
}

 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String fileContent = "";
        reader.close();
        while (fileReader.ready()) {
            fileContent += fileReader.readLine();
        }
        fileReader.close();
        separateTag(fileContent, args[0]);
    }

    public static void separateTag(String text, String tag) {
        String close = "</" + tag + ">";
        Pattern p = Pattern.compile("<" + tag + "[^>]*+>" + "|" + close);
        int indexStart = 0, indexEnd = 0, result = -1;
        Map<Integer, Integer> mapStart = new TreeMap<>();

        Matcher m =  p.matcher(text);
        while (m.find()) {
            if (!m.group().equals(close)) mapStart.put(++indexStart, m.start());
            else if(indexStart > 0) indexEnd++;
            result = indexStart - indexEnd;
            if (result == 0 && indexStart != 0) {
                System.out.println(text.substring(mapStart.get(1), m.end()));
                String sub = text.substring(mapStart.get(1)+m.group().length()-1, m.end()-close.length());
                separateTag(sub, tag);
                indexEnd = 0; indexStart = 0;
            }
        }
        if (result > 0){
            System.out.println(text.substring(mapStart.get(1+result), text.lastIndexOf(close)+close.length()));
            separateTag(text.substring(mapStart.get(1+result)+m.group().length()-1), tag);
        }
    }

}