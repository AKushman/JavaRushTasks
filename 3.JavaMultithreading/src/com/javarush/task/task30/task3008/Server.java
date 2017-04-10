package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;
        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME && !message.getData().isEmpty() && !connectionMap.containsKey(message.getData()))
                {
                   connectionMap.put(message.getData(), connection);
                   connection.send(new Message(MessageType.NAME_ACCEPTED));
                   return message.getData();
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> con : connectionMap.entrySet()) {
                if (!con.getKey().equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, con.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String text = userName.concat(": ").concat(message.getData());
                    Message sendMsg = new Message(MessageType.TEXT, text);
                    sendBroadcastMessage(sendMsg);
                }
                else {
                    System.out.println("Ошибочное сообщение");
                }
            }
        }

        @Override
        public void run() {
            String userName = null;
            ConsoleHelper.writeMessage("Новое соединение установлено: " + socket.getRemoteSocketAddress());
            try(Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            }
            catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом.");
            }
            catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом.");
            }
            finally {
                if (userName != null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            }
            ConsoleHelper.writeMessage("Соединение закрыто. " + socket.getRemoteSocketAddress());
        }
    }

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        try (ServerSocket socket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                new Handler(socket.accept()).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка подключения");
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> connection : connectionMap.entrySet()) {
            try {
                connection.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не удалось отправить сообщение.");
            }
        }
    }
}
