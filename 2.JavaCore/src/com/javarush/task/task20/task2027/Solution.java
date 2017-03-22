package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same", "rev", "rad", "pnu");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> allWords = new ArrayList<>();

        //слова по горизонтали
        for (int i = 0; i < crossword.length; i++) {
            //String row = crossword[i].toString();
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < crossword[i].length; j++) {
                row.append((char) crossword[i][j]);
            }

            for (String s : words) {
                if (row.toString().contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(row.indexOf(s), i);
                    word.setEndPoint(row.indexOf(s) + s.length() - 1, i);
                    allWords.add(word);
                }
                if (row.reverse().toString().contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(row.length() - row.indexOf(s) - 1, i);
                    word.setEndPoint(row.length() - row.indexOf(s) - s.length(), i);
                    allWords.add(word);
                }
                row.reverse();
            }
        }

        //слова по вертикали
        for (int j = 0; j < crossword[0].length; j++) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < crossword.length; i++) {
                row.append((char) crossword[i][j]);
            }
            for (String s : words) {
                if (row.toString().contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(j, row.indexOf(s));
                    word.setEndPoint(j, row.indexOf(s) + s.length() - 1);
                    allWords.add(word);
                }
                if (row.reverse().toString().contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(j, row.length() - row.indexOf(s) - 1);
                    word.setEndPoint(j, row.length() - row.indexOf(s) - s.length());
                    allWords.add(word);
                }
                row.reverse();
            }
        }

        //по главной диагонали
        for (int i = 0; i < crossword.length; i++) {
            int y = i;
            int x = 0;
            StringBuilder row = new StringBuilder();
            while (y < crossword.length && x < crossword[y].length) {
                row.append((char) crossword[y][x]);
                x++;
                y++;
            }
            for (String s : words) {
                if (row.toString().contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(row.indexOf(s), row.indexOf(s) + i);
                    word.setEndPoint(row.indexOf(s) + (s.length() - 1), row.indexOf(s) + i + s.length() - 1);
                    allWords.add(word);
                }
                if (row.reverse().toString().contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(x - row.indexOf(s) - 1, y - row.indexOf(s) - 1);
                    word.setEndPoint(x - s.length() - row.indexOf(s), y - s.length() - row.indexOf(s));
                    allWords.add(word);
                }
                row.reverse();
            }
        }

        for (int i = 1; i < crossword[0].length; i++) {
            int y = 0;
            int x = i;
            StringBuilder row = new StringBuilder();
            while (y < crossword.length && x < crossword[y].length) {
                row.append((char) crossword[y][x]);
                x++;
                y++;
            }
            for (String s : words) {
                if (row.toString().contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(row.indexOf(s) + i, row.indexOf(s));
                    word.setEndPoint(row.indexOf(s) + i + s.length() - 1 , row.indexOf(s) + (s.length() - 1));
                    allWords.add(word);
                }
                if (row.reverse().toString().contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(x - row.indexOf(s) - 1, y - row.indexOf(s) - 1);
                    word.setEndPoint(x - s.length() - row.indexOf(s), y - s.length() - row.indexOf(s));
                    allWords.add(word);
                }
                row.reverse();
            }
        }

        //по второй диагонали
        for (int i = 0; i < crossword[0].length; i++) {
            int x = i;
            int y = 0;
            StringBuilder row = new StringBuilder();
            while (x > -1 && y < crossword.length) {
                row.append((char) crossword[y][x]);
                x--;
                y++;
            }
            for (String s : words) {
                if (row.toString().contains(s)) {
                    Word word = new Word(s);
                    word.setStartPoint(i - row.indexOf(s), row.indexOf(s));
                    word.setEndPoint(i - row.indexOf(s) + (s.length() - 1), row.indexOf(s) + s.length() - 1);
                    allWords.add(word);
                }
                if (row.reverse().toString().contains(s)) {
                    Word word = new Word(s);
                    int startX = i - (row.length() - 1) + row.indexOf(s);
                    int startY = y - 1 - row.indexOf(s);
                    word.setStartPoint(startX, startY);
                    word.setEndPoint(startX + (s.length() - 1), startY - (s.length() - 1));
                    allWords.add(word);
                }
                row.reverse();
            }


        }

        for (int i = 1; i < crossword.length; i++) {
            int x = crossword[i].length -1;
            int y = i;
            StringBuilder row = new StringBuilder();
            while (x > -1 && y < crossword.length) {
                row.append((char) crossword[y][x]);
                x--;
                y++;
            }
            for (String s : words) {
                if (row.toString().contains(s)) {
                    Word word = new Word(s);
                    int startX = crossword[i].length - 1 - row.indexOf(s);
                    int startY = i + row.indexOf(s);
                    word.setStartPoint(startX, startY);
                    word.setEndPoint(startX - (s.length() - 1), startY + (s.length() - 1));
                    allWords.add(word);
                }
                if (row.reverse().toString().contains(s)) {
                    Word word = new Word(s);
                    int startX = x + 1 + row.indexOf(s);
                    int startY = y - 1 - row.indexOf(s);
                    word.setStartPoint(startX, startY);
                    word.setEndPoint(startX + (s.length() - 1), startY - (s.length() - 1));
                    allWords.add(word);
                }
                row.reverse();
            }
        }

        return allWords;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
