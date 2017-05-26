package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        int size = 0;
        for (List<V> list : map.values()) {
            size += list.size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        if (map.containsKey(key) && map.get(key).size() < repeatCount) {
            map.get(key).add(value);
            return map.get(key).get(map.get(key).size() - 2);
        }
        else if (map.containsKey(key) && map.get(key).size() == repeatCount){
            map.get(key).remove(0);
            map.get(key).add(value);
            return map.get(key).get(map.get(key).size() - 2);
        }
        else {
            List<V> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        List<V> values = map.get(key);
        if (values == null)
            return null;
        V value = values.get(0);
        values.remove(0);
        if (values.size() == 0)
            map.remove(key);
        return value;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        List<V> list = new ArrayList<>();
        for (List<V> l : map.values()) {
            for (V v: l) {
                list.add(v);
            }
        }
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        boolean contains = false;
        for (List<V> l : map.values()) {
            if (l.contains(value))
                contains = true;
        }
        return contains;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}