package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static class Handler extends Thread {
        private Socket socket;
        public Handler(Socket socket) {
            this.socket = socket;
        }
    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        try (ServerSocket socket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");
            while (true) {
                new Handler(socket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Ошибка подключения");
        }
    }
}