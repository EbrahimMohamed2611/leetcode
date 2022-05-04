package com.leetcode.easy;


import java.util.*;

/**
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 * Companies [Amazon-Google-Facebook]
 */
public class LargestSubstringBetweenTwoEqualCharacters_1624 {

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("abca"));
        System.out.println(maxLengthBetweenEqualCharacters("adfg"));
        System.out.println(maxLengthBetweenEqualCharacters("aa"));
        System.out.println(maxLengthBetweenEqualCharacters("a"));
        System.out.println(maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(maxLengthBetweenEqualCharacters("aabsdasab"));
    }


    /**
     * Time O(N)
     * Space O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest Substring Between Two Equal Characters.
     * Memory Usage: 40.1 MB, less than 86.16% of Java online submissions for Largest Substring Between Two Equal Characters.
     * @param s
     * @return
     */
    public static int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
       int[] englishLetters = new int[26];
        Arrays.fill(englishLetters, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch  = s.charAt(i);
            if(englishLetters[ch - 'a'] == -1)
                englishLetters[ch - 'a'] = i;
            else{
                ans = Math.max(ans, i - 1 - englishLetters[ch - 'a']);
            }
        }
        return ans;
    }


    /**
     * Time O(N)
     * Space O(N)
     * Runtime: 1 ms, faster than 84.21% of Java online submissions for Largest Substring Between Two Equal Characters.
     * Memory Usage: 41.8 MB, less than 56.34% of Java online submissions for Largest Substring Between Two Equal Characters.
     */

    public static int maxLengthBetweenEqualCharacters3(String s) {
        int ans = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch  = s.charAt(i);
            if (map.containsKey(ch)) {
                ans = Math.max(ans, i - 1 - map.get(ch));
            }
            else {
                map.put(ch, i);
            }
        }
        return ans;
    }


    /**
     * Time O(N)
     * Space O(N)
     * Runtime: 1 ms, faster than 84.21% of Java online submissions for Largest Substring Between Two Equal Characters.
     * Memory Usage: 41.8 MB, less than 61.79% of Java online submissions for Largest Substring Between Two Equal Characters.
     * @param s
     * @return
     */
    public static int maxLengthBetweenEqualCharacters2(String s) {
        int maxDistance = -1;
        for (int i = 0; i < s.length(); i++) {
          char currentCharacter = s.charAt(i);
          int lastIndex = s.lastIndexOf(currentCharacter);
          if(lastIndex != i){
              maxDistance = Math.max(maxDistance, (lastIndex - i-1));
          }
        }
        return maxDistance;
    }

    /**
     * Time O(N^2)
     * Space O(N)
     * Runtime: 6 ms, faster than 12.67% of Java online submissions for Largest Substring Between Two Equal Characters.
     * Memory Usage: 40.2 MB, less than 86.16% of Java online submissions for Largest Substring Between Two Equal Characters.
     * @param s
     * @return
     */
    public static int maxLengthBetweenEqualCharacters1(String s) {
        int maxDistance = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    maxDistance = Math.max(maxDistance, (j - i-1));
                }
            }
        }
        return maxDistance;
    }
}
