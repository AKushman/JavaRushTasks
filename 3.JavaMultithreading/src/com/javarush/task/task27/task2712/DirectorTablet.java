package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.Locale;
import java.util.Map;

public class DirectorTablet {


    public void printAdvertisementProfit() {
        double totalMoney = 0;
        for (Map.Entry<String, Long> video : StatisticManager.getInstance().getAdvertisementProfit().entrySet()) {

            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", video.getKey(), (double)video.getValue() / 100));
            totalMoney += video.getValue();
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", totalMoney / 100));
    }

    public void printCookWorkloading() {

        for (Map.Entry<String, Map<String, Integer>> byDates : StatisticManager.getInstance().getCookLoading().entrySet()) {
            ConsoleHelper.writeMessage(byDates.getKey());
            for (Map.Entry<String, Integer> cook : byDates.getValue().entrySet()) {
                if (cook.getValue() == 0)
                    continue;
                int time = cook.getValue() / 60;
                if (cook.getValue() % 60 != 0)
                    time++;
                ConsoleHelper.writeMessage(cook.getKey() + " - " + time + " min");
            }
            ConsoleHelper.writeMessage("");
        }
    }
    public void printActiveVideoSet() {

    }
    public void printArchivedVideoSet() {

    }
}
