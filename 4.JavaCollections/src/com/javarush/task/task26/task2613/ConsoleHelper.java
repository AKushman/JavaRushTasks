package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String result = "";
        try {
            result = bis.readLine();
            if (result.equalsIgnoreCase("exit"))
                throw new InterruptOperationException();
        } catch (IOException e) {}
        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String currencyCode = "";
        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            currencyCode = readString();
            if (currencyCode.length() != 3)
                writeMessage(res.getString("invalid.data"));
            else break;
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] money = null;
        while (true) {
            writeMessage(res.getString("choose.denomination.and.count.format"));
            money = readString().split(" ");
            if (money.length != 2 || money == null) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            try {
                if (Integer.parseInt(money[0]) > 0 && Integer.parseInt(money[1]) > 0)
                    break;
                else writeMessage(res.getString("invalid.data"));
            }
            catch (NumberFormatException e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
        }
        return money;
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.operation"));
            writeMessage("1 - " + res.getString("operation.INFO"));
            writeMessage("2 - " + res.getString("operation.DEPOSIT"));
            writeMessage("3 - " + res.getString("operation.WITHDRAW"));
            writeMessage("4 - " + res.getString("operation.EXIT"));
            try {
                int operation = Integer.parseInt(readString());
                return Operation.getAllowableOperationByOrdinal(operation);
            }
            catch (NumberFormatException e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            catch (IllegalArgumentException e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
        }
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}
