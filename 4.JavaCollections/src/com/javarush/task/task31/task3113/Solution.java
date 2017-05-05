package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path directory = Paths.get(reader.readLine());
        if (!Files.isDirectory(directory)){
            System.out.println(directory.getFileName().toAbsolutePath().toString() + " - не папка");
            return;
        }
        Files.walkFileTree(directory, new MyFileVisitor());
        System.out.println("Всего папок - " + dirs);
        System.out.println("Всего файлов - " + files);
        System.out.println("Общий размер - " + size);
    }
    static int dirs = -1;
    static int files = 0;
    static long size = 0;

    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            files++;
            size += attrs.size();
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            dirs++;
            size += attrs.size();
            return super.preVisitDirectory(dir, attrs);
        }
    }
}
