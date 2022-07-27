package com.leetcode.easy;

import java.util.*;

// https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharacterInAString_387 {
    /**
     * 1 <= s.length <= 105
     * s consists of only lowercase English letters.
     Runtime: 5 ms, faster than 97.93% of Java online submissions for First Unique Character in a String.
     Memory Usage: 42.5 MB, less than 97.25% of Java online submissions for First Unique Character in a String.
     */
    public static int firstUniqChar(String s) {
        int[] frequency = new int[26]; // we have only lowerCase Letters
        int length = s.length();
        int position;
        for (int i = 0; i < length; i++) {
            position = s.charAt(i) - 'a';
            frequency[position] = frequency[position] + 1;
        }
        for (int i = 0; i < length; i++) {
            if(frequency[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }

    /**
     * 1 <= s.length <= 105
     * s consists of only lowercase English letters.
     * <p>
     * Runtime: 41 ms, faster than 47.57% of Java online submissions for First Unique Character in a String.
     * Memory Usage: 54.2 MB, less than 31.83% of Java online submissions for First Unique Character in a String.
     */
    public static int firstUniqChar2(String s) {
        int length = s.length();
        if (length == 1)
            return 0;

        final Map<Character, Integer> characterOccurrence = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char current = s.charAt(i);
            characterOccurrence.put(current, characterOccurrence.getOrDefault(current, 0) + 1);

        }

        for (int i = 0; i < length; i++) {
            if (characterOccurrence.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode")); // 0
        System.out.println(firstUniqChar("loveleetcode")); // 2
        System.out.println(firstUniqChar("aabb")); // -1
    }
}
