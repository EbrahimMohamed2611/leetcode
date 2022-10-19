package com.leetcode.medium;

import java.util.*;

public class TimeBasedKeyValueStore_981 {

    /*
    Runtime: 295 ms, faster than 78.76% of Java online submissions for Time Based Key-Value Store.
    Memory Usage: 216.3 MB, less than 68.58% of Java online submissions for Time Based Key-Value Store.
     */
    private static class Pair {
        String value;
        int timestamp;

        public Pair(String value, int time) {
            this.value = value;
            this.timestamp = time;
        }
    }

    private final Map<String, List<Pair>> keyValueMap;

    public TimeBasedKeyValueStore_981() {
        keyValueMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!keyValueMap.containsKey(key))
            keyValueMap.put(key, new ArrayList<>());

        keyValueMap.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!keyValueMap.containsKey(key)) return "";
        else
            return search(key, timestamp);
    }

    private String search(String key, int timestamp) {
        int left = 0;
        int right = keyValueMap.get(key).size() - 1;
        List<Pair> arr = keyValueMap.get(key);
        int mid = 0;
        String result = "";
        while (right >= left) {
            mid = (right + left) / 2;
            if (arr.get(mid).timestamp == timestamp)
                return arr.get(mid).value;
            else if (arr.get(mid).timestamp < timestamp) {
                result = arr.get(mid).value;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore_981 timeBasedKey = new TimeBasedKeyValueStore_981();
        /*
        ["TimeMap","set","get","get","set","get","get"]
        [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
         */
        timeBasedKey.set("foo", "bar", 1);
        System.out.println(timeBasedKey.get("foo", 1));
        System.out.println(timeBasedKey.get("foo", 3));
        timeBasedKey.set("foo", "bar2", 4);
        System.out.println(timeBasedKey.get("foo", 4));
        System.out.println(timeBasedKey.get("foo", 5));
        /*
        [null,null,"bar","bar",null,"bar2","bar2"]
         */
    }
}
