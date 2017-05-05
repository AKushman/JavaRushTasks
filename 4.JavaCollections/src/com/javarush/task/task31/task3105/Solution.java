package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zip = args[1];
        Path tmp = Files.createTempFile(null, null);
        ZipOutputStream zipOutput = new ZipOutputStream(Files.newOutputStream(tmp));
        ZipInputStream zipInput = new ZipInputStream(Files.newInputStream(Paths.get(zip)));
        ZipEntry entry = zipInput.getNextEntry();
        while (entry != null) {
            String archivedFileName = entry.getName();
            zipOutput.putNextEntry(new ZipEntry(archivedFileName));
            copyData(zipInput, zipOutput);
            zipInput.closeEntry();
            zipOutput.closeEntry();

            entry = zipInput.getNextEntry();
        }
        zipInput.close();
        ZipEntry fileToAdd = new ZipEntry("new/" + Paths.get(fileName).getFileName());
        zipOutput.putNextEntry(fileToAdd);
        InputStream inputFile = Files.newInputStream(Paths.get(fileName));
        copyData(inputFile, zipOutput);
        zipOutput.closeEntry();
        inputFile.close();
        zipOutput.close();
        Files.copy(tmp, Paths.get(zip), StandardCopyOption.REPLACE_EXISTING);

    }

    private static void copyData(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}
