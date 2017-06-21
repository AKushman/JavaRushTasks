package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (!denominations.containsKey(denomination))
            denominations.put(denomination, count);
        else denominations.merge(denomination, count, (i1, i2) -> i1 + i2);
    }

    public int getTotalAmount() {
        int total = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
            total += pair.getKey() * pair.getValue();
        }
        return total;
    }

    public boolean hasMoney() {
        return getTotalAmount() != 0;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        if (getTotalAmount() < expectedAmount)
            throw new NotEnoughMoneyException();
        List<Integer> nominals = new ArrayList<>(denominations.keySet());
        Collections.sort(nominals, Comparator.reverseOrder());
        Map<Integer, Integer> copyDenom = new TreeMap<>(Comparator.reverseOrder());
        copyDenom.putAll(denominations);
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nominals.size(); ) {
            int banknote = nominals.get(i);
            if (banknote <= expectedAmount && copyDenom.containsKey(banknote) && copyDenom.get(banknote) > 0) {
                result.merge(banknote, 1, (i1, i2) -> i1 + i2);
                copyDenom.merge(banknote, -1, (i1, i2) -> i1 + i2);
                expectedAmount -= banknote;
            }
            else i++;
            if (copyDenom.containsKey(banknote) && copyDenom.get(banknote) == 0) {
                copyDenom.remove(banknote);
            }
        }
        if (expectedAmount > 0)
            throw new NotEnoughMoneyException();
        denominations.clear();
        denominations.putAll(copyDenom);
        return result;
    }


}
