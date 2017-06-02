package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date startTime = new Date();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        return new Date().getTime() - startTime.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date startTime = new Date();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        return new Date().getTime() - startTime.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> origIds = new HashSet<>();
        long timeForIdsHashMapSS = getTimeForGettingIds(shortener1, origStrings, origIds);
        origIds.clear();
        long timeForIdsHashBiMapSS = getTimeForGettingIds(shortener2, origStrings, origIds);
        Assert.assertTrue(timeForIdsHashMapSS > timeForIdsHashBiMapSS);
        origStrings.clear();
        long timeForStringsHashMapSS = getTimeForGettingStrings(shortener1, origIds, origStrings);
        origStrings.clear();
        long timeForStringsHashBiMapSS = getTimeForGettingStrings(shortener2, origIds, origStrings);
        Assert.assertEquals(timeForStringsHashMapSS, timeForStringsHashBiMapSS, 30);
    }
}
