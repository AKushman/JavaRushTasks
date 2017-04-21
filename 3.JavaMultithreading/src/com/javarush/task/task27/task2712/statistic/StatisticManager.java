package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();
    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {

    }
    public static StatisticManager getInstance() {
        return ourInstance;
    }

    public void register(EventDataRow data) {
        if (data == null)
            return;
        statisticStorage.put(data);
    }

    private class StatisticStorage {
        private Map<EventType, List> storage = new HashMap<>();

        private StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        private List<EventDataRow> get(EventType type) {
            return storage.get(type);
        }
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

    public Map<String, Long> getAdvertisementProfit() {
        List<EventDataRow> list = statisticStorage.get(EventType.SELECTED_VIDEOS);
        Map<String, Long> profitByDate = new TreeMap<>(Collections.reverseOrder());
        for (EventDataRow event : list) {
            VideoSelectedEventDataRow videoRow = (VideoSelectedEventDataRow) event;
            profitByDate.merge(dateFormat.format(videoRow.getDate()), videoRow.getAmount(), (aLong, aLong2) -> aLong + aLong2);
        }
        return profitByDate;
    }

    public Map<String, Map<String, Integer>> getCookLoading() {
        List<EventDataRow> list = statisticStorage.get(EventType.COOKED_ORDER);
        Map<String, Map<String, Integer>> coockMap = new TreeMap<>(Collections.reverseOrder());
        for (EventDataRow event : list) {
            CookedOrderEventDataRow cookEvent = (CookedOrderEventDataRow) event;
            if (!coockMap.containsKey(dateFormat.format(event.getDate())))
                coockMap.put(dateFormat.format(event.getDate()), new TreeMap<>(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                }));
            Map<String, Integer> cookOnOneDay = coockMap.get(dateFormat.format(event.getDate()));
            cookOnOneDay.merge(cookEvent.getCookName(), cookEvent.getTime(), (integer, integer2) -> integer + integer2);
        }
        return coockMap;
    }
}
