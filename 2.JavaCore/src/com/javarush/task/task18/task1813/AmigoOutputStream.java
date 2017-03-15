package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream fileOutputStream;

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void write(int i) throws IOException {
        fileOutputStream.write(i);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        fileOutputStream.write(bytes);
    }

    @Override
    public void write(byte[] bytes, int i, int i1) throws IOException {
        fileOutputStream.write(bytes, i, i1);
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void close() throws IOException {
        flush();
        byte[] rights = "JavaRush © All rights reserved.".getBytes();
        write(rights);
        fileOutputStream.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
