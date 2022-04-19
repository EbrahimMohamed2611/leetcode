package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons_1189 {
    // b a ll oo n
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("leetcode"));
        System.out.println(maxNumberOfBalloons("lloo"));
    }


    /**
     * Using Frequency Array
     * Time O(N)
     * Space O(1)
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Number of Balloons.
     * Memory Usage: 42.9 MB, less than 30.32% of Java online submissions for Maximum Number of Balloons.
     * @param text
     * @return
     */
    public static int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(char c: text.toCharArray())
            freq[c - 'a']++;

        return Math.min(Math.min(freq['o'-'a']/2, freq['l'-'a']/2), Math.min(Math.min(freq['b'-'a'], freq['a'-'a']), freq['n'-'a']));

    }


    /**
     * Time O(N)
     * Space O(N)
     * Runtime: 11 ms, faster than 16.85% of Java online submissions for Maximum Number of Balloons.
     * Memory Usage: 42.6 MB, less than 44.40% of Java online submissions for Maximum Number of Balloons.
     * @param text
     * @return
     */
    public static int maxNumberOfBalloons2(String text) {
        Map<Character, Integer> characterWithCount = new HashMap<>();
        characterWithCount.put('b', 1);
        characterWithCount.put('a', 1);
        characterWithCount.put('l', 2);
        characterWithCount.put('o', 2);
        characterWithCount.put('n', 1);

        Map<Character, Integer> textCount = new HashMap<>();
        textCount.put('b', 0);
        textCount.put('a', 0);
        textCount.put('l', 0);
        textCount.put('o', 0);
        textCount.put('n', 0);

        for (char c : text.toCharArray()) {
            if (textCount.containsKey(c)) {
                    int counter = textCount.get(c);
                    textCount.put(c, counter + 1);
            }
        }


        int result = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : textCount.entrySet()) {
            int count = entry.getValue() / characterWithCount.get(entry.getKey());
            if (result > count)
                result = count;
        }
        return result;
    }
}
