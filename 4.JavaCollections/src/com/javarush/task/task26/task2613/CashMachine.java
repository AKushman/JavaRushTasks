package com.javarush.task.task26.task2613;


import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

public class CashMachine {
    public static final String RESOURCE_PATH = CashMachine.class.getPackage().toString().substring(8) + ".resources.";

    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.ENGLISH);
            CommandExecutor.execute(Operation.LOGIN);
            Operation op;
            do {
                op = ConsoleHelper.askOperation();
                CommandExecutor.execute(op);
            }
            while (!op.equals(Operation.EXIT));
        } catch (InterruptOperationException e) {
            ConsoleHelper.printExitMessage();
        }
    }

}
