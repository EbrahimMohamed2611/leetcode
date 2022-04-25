package com.leetcode.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern_290 {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        String pattern2 = "abba", s2 = "dog dog dog dog";

        String p = "abba", st = "dog cat cat fish";
        System.out.println(wordPattern(pattern, s));
        System.out.println(wordPattern(p, st));
        System.out.println(wordPattern(pattern2, s2));
    }


    /**
     * Time O(N)
     * Space O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Word Pattern.
     * Memory Usage: 40 MB, less than 90.35% of Java online submissions for Word Pattern.
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern(String pattern, String str) {
        String[] arr= str.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }
}


