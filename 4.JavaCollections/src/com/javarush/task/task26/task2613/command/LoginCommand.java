package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String cardString = ConsoleHelper.readString();
            String pinString = ConsoleHelper.readString();
            if (cardString.length() != 12 || pinString.length() != 4) {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardString));
                continue;
            }
            if (validCreditCards.containsKey(cardString) && validCreditCards.getString(cardString).equals(pinString)) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardString));
                break;
            }
            else {
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }
    }
}
