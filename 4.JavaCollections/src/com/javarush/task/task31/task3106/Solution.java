package com.javarush.task.task31.task3106;


import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args)  {
        try (FileOutputStream out = new FileOutputStream(args[0])) {
            List<String> fileParts = Arrays.asList(args).subList(1, args.length);
            Collections.sort(fileParts);
            List<InputStream> streams = new ArrayList<>();
            for (String part : fileParts) {
                streams.add(new FileInputStream(part));
            }
            SequenceInputStream seq = new SequenceInputStream(Collections.enumeration(streams));
            ZipInputStream zis = new ZipInputStream(seq);

            int len;
            byte[] buf = new byte[8 * 1024];
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                while ((len = zis.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                zipEntry = zis.getNextEntry();
            }
            seq.close();
            zis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
