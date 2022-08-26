package com.leetcode.medium;

import java.util.*;

//https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning_131 {
    /*
    Runtime: 10 ms, faster than 91.70% of Java online submissions for Palindrome Partitioning.
    Memory Usage: 54.4 MB, less than 96.37% of Java online submissions for Palindrome Partitioning.
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> allPartitionSubStrings = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partitionRecursive(0, s, allPartitionSubStrings, path);
        return allPartitionSubStrings;
    }

    private static void partitionRecursive(int index, String s, List<List<String>> allPartitionSubStrings, List<String> path) {
        if (index == s.length())
            allPartitionSubStrings.add(new ArrayList<>(path));
        else {
            for (int i = index; i < s.length(); i++) {
                if (isPalindrome(s, index, i)) {
                    path.add(s.substring(index, i+1));
                    partitionRecursive(i + 1, s, allPartitionSubStrings, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    private static boolean isPalindrome(String string, int start, int end) {
        while (end >= start) {
            if (string.charAt(start++) != string.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("a"));
        System.out.println(partition("aabb"));
    }
}
