package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }
        catch (IOException ex) {}
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileToRead;
        private String content = "";
        @Override
        public void setFileName(String fullFileName) {
            this.fileToRead = fullFileName;
        }

        @Override
        public String getFileContent() {
            return content;
        }

        @Override
        public void run() {
            Scanner sc = null;
            try {
                sc = new Scanner(new FileReader(fileToRead));
            }
            catch (FileNotFoundException ex) {}
            while (sc.hasNext()) {
                content += sc.nextLine() + " ";
            }
        }
    }
}
