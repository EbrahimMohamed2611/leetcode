package com.leetcode.medium;

public class ReverseWordsInAString_151 {
            /*
        Runtime: 6 ms, faster than 88.45% of Java online submissions for Reverse Words in a String.
        Memory Usage: 42.2 MB, less than 94.88% of Java online submissions for Reverse Words in a String.
        */
    public String reverseWords(String string) {
        // string can have more than one space, so we need to neglect all this space
        String[] strings = string.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            stringBuilder.append(strings[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
