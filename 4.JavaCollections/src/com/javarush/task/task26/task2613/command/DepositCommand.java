package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currCode);
        int den = 0;
        int count = 0;
        try {
            String[] money = ConsoleHelper.getValidTwoDigits(currCode);
            den = Integer.parseInt(money[0]);
            count = Integer.parseInt(money[1]);
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
        manipulator.addAmount(den, count);
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), den * count, currCode));

    }
}

