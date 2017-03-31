package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        List<String> words = new ArrayList<>();
        while (fileReader.ready()) {
            Collections.addAll(words, fileReader.readLine().split(" "));
        }
        while (true){
            String checkingWord = words.get(0);
            for (int i = 1; i < words.size(); i++) {
                String toCheck = new StringBuilder(words.get(i)).reverse().toString();
                if (toCheck.equals(checkingWord)) {
                    Pair pair = new Pair();
                    pair.first = checkingWord;
                    pair.second = words.get(i);
                    words.removeIf(s -> s.equals(pair.second));
                    result.add(pair);
                    break;
                }
            }
            words.removeIf(s -> s.equals(checkingWord));
            if (words.size() == 0)
                break;
        }
        reader.close();
        fileReader.close();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
