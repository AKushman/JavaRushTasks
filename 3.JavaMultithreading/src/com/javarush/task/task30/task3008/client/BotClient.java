package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            int divider = 0;
            if (message.contains(": ")) {
                divider = message.indexOf(": ");
            }
            String userName = "";
            String request;
            SimpleDateFormat dateFormat = null;
            if (divider != 0)
            {
                userName = message.substring(0, divider);
                request = message.substring(divider + 2);
                if ("дата".equals(request))
                    dateFormat = new SimpleDateFormat("d.MM.YYYY");
                if ("день".equals(request))
                    dateFormat = new SimpleDateFormat("d");
                if ("месяц".equals(request))
                    dateFormat = new SimpleDateFormat("MMMM");
                if ("год".equals(request))
                    dateFormat = new SimpleDateFormat("YYYY");
                if ("время".equals(request))
                    dateFormat = new SimpleDateFormat("H:mm:ss");
                if ("час".equals(request))
                    dateFormat = new SimpleDateFormat("H");
                if ("минуты".equals(request))
                    dateFormat = new SimpleDateFormat("m");
                if ("секунды".equals(request))
                    dateFormat = new SimpleDateFormat("s");
            }
            if (dateFormat!=null) {
                sendTextMessage(String.format("Информация для %s: %s", userName, dateFormat.format(Calendar.getInstance().getTime())));
            }

        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random()*100);
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}
