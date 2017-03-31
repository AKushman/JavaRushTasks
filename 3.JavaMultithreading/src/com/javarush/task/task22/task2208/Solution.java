package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;
/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null)
                sb.append(String.format("%s = '%s' and ", pair.getKey(), pair.getValue()));
        }
        if (sb.length() > 5)
            sb = sb.delete(sb.length() - 5, sb.length());
        return sb.toString();
    }
}
