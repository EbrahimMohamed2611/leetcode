package com.leetcode.easy;


import java.util.*;

/**
 * https://leetcode.com/problems/slowest-key/
 * Companies [ Amazon-Google-Microsoft-Uber-facebook-adobe]
 */
public class SlowestKey_1629 {
    public static void main(String[] args) {
        System.out.println(slowestKey(new int[]{9,29,49,50},"cbcd")); //c
        System.out.println(slowestKey(new int[]{12,23,36,46,62},"spuda")); //a
    }

    /**
     * Time O(N)
     * Space O(1)
     * Runtime: 1 ms, faster than 91.39% of Java online submissions for Slowest Key.
     * Memory Usage: 44.5 MB, less than 64.84% of Java online submissions for Slowest Key.
     * @param releaseTimes
     * @param keysPressed
     * @return
     */

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int maxDuration = releaseTimes[0];
        char slowestKey = keysPressed.charAt(0);
        for (int i = 1; i < n; i++) {
            int duration = releaseTimes[i] - releaseTimes[i-1];

            if (duration > maxDuration ||  (duration == maxDuration && keysPressed.charAt(i) > slowestKey)) {
                maxDuration = duration;
                slowestKey = keysPressed.charAt(i);
            }
        }
        return slowestKey;
    }

    /**
     * Runtime: 7 ms, faster than 10.53% of Java online submissions for Slowest Key.
     * Memory Usage: 45.7 MB, less than 5.34% of Java online submissions for Slowest Key.
     * @param releaseTimes
     * @param keysPressed
     * @return
     */
    public static char slowestKey1(int[] releaseTimes, String keysPressed) {
        char[] chars = keysPressed.toCharArray();
        Map<Character, Integer> charWithTim = new HashMap<>();
        int[] times = new int[releaseTimes.length];
        charWithTim.put(chars[0], (releaseTimes[0]));
        times[0] = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            if(charWithTim.containsKey(chars[i]) && (releaseTimes[i]-releaseTimes[i-1]) < charWithTim.get(chars[i]))
                continue;

            charWithTim.put(chars[i], (releaseTimes[i]-releaseTimes[i-1]));
            times[i] = (releaseTimes[i]-releaseTimes[i-1]);
        }
       Arrays.sort(times);
        List<Character> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry: charWithTim.entrySet()){
            if(entry.getValue() == times[times.length-1])
                list.add(entry.getKey());
        }
       Collections.sort(list);
        return list.get(list.size()-1);
    }
}
