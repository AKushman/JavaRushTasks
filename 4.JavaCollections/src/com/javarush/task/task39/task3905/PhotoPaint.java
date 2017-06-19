package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int r, int c, Color desiredColor) {
       if (r < 0 || c < 0 || r >= image.length || c >= image[r].length)
           return false;
       if (image[c][r].equals(desiredColor))
           return false;
       else {
           image[c][r] = desiredColor;
           return true;
       }
    }
}
