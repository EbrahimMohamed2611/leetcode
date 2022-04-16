package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram_424 {
    public static void main(String[] args) {
      String  s = "anagram", t = "nagaram";
      String  s2 = "rat", t2 = "car";
        System.out.println(isAnagram(s,t));
        System.out.println(isAnagram(s2,t2));
        System.out.println(isAnagram2(s,t));
        System.out.println(isAnagram3(s2,t2));
    }


    private static boolean isAnagram2(String s, String t){
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }

    /**
     * Runtime: 2 ms, faster than 98.82% of Java online submissions for Valid Anagram.
     * Memory Usage: 42.1 MB, less than 96.92% of Java online submissions for Valid Anagram.
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram3(String s, String t){
        int[] s1 = new int[26];
        int[] t1 = new int[26];
        for (char ch : s.toCharArray()) {
            s1[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            t1[ch - 'a']++;
        }
        return Arrays.equals(s1, t1);
    }

    private static boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;
        else{
            Map<Character, Integer> characterWithNumber = new HashMap<>();
            for (char ch:s.toCharArray()) {
                if(!characterWithNumber.containsKey(ch))
                    characterWithNumber.put(ch,1);
                else{
                    characterWithNumber.put(ch,characterWithNumber.get(ch)+1);
                }
            }

            for (char ch:t.toCharArray()) {
                if(characterWithNumber.get(ch) == null){
                    return false;
                }else{

                    int count = characterWithNumber.get(ch);
                    characterWithNumber.put(ch, count - 1);
                    if (characterWithNumber.get(ch) < 0)
                        return false;
                }
            }
            }
        return true;
        }

    }

