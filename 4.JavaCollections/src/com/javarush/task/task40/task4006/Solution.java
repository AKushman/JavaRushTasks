package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        try(Socket socket = new Socket(url.getHost(), 80);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()) {
            PrintWriter pw = new PrintWriter(outputStream);
            pw.println("GET " + url.getPath());
            pw.println("Host: " + url.getHost());
            pw.println("User-Agent: Mozilla/5.0");
            pw.println("Accept: text/html");
            pw.println("Connection: close");
            pw.println("");
            pw.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}