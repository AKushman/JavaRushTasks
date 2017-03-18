package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Alexander on 12.03.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        ImageReader imageReader;
        if (ImageTypes.JPG.equals(type))
            imageReader = new JpgReader();
        else if (ImageTypes.BMP.equals(type))
            imageReader = new BmpReader();
        else if (ImageTypes.PNG.equals(type))
            imageReader = new PngReader();
        else throw new IllegalArgumentException();
        return imageReader;
    }
}
