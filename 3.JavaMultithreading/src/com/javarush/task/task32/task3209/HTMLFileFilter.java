package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        String fileName = file.getName().toLowerCase();
        if (file.isDirectory())
            return true;
        return !fileName.endsWith(".html") ? fileName.endsWith(".htm") : true;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
