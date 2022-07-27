package com.leetcode.easy;

public class FindSmallestLetterGreaterThanTarget_744 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Smallest Letter Greater Than Target.
     * Memory Usage: 48.5 MB, less than 14.09% of Java online submissions for Find Smallest Letter Greater Than Target.
     * @param letters
     */
    public static char nextGreatestLetter(char[] letters, char key) {
        if (key < letters[0] || key > letters[letters.length - 1])
            return letters[0];

        int start = 0;
        int end = letters.length - 1;
        int mid;
        while (end >= start) {
            mid = start + (end - start) / 2;
            if (key == letters[mid]) {
                start = mid + 1;
            } else if (key > letters[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return letters[start % letters.length];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
    }
}
