package com.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class ReplaceElementsWithGreatestElementOnRightSide_1299 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(replaceElements(new int[]{17, 18, 5, 4, 6, 1}))); // [18,6,6,6,1,-1]
        System.out.println(Arrays.toString(replaceElements(new int[]{400}))); // [18,6,6,6,1,-1]
    }

    /**
     * Time O(N)
     * Space O(1)
     *
     * Iterate Reverse
     *Runtime: 2 ms, faster than 55.16% of Java online submissions for Replace Elements with Greatest Element on Right Side.
     * Memory Usage: 54.9 MB, less than 17.54% of Java online submissions for Replace Elements with Greatest Element on Right Side.
     * @param arr
     * @return
     */
    public static int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; --i) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(max, tmp);
        }
        return arr;
    }

    /**
     * Time O(N^2)
     * Space O(N)
     * BruteForce
     * Runtime: 217 ms, faster than 17.29% of Java online submissions for Replace Elements with Greatest Element on Right Side.
     * Memory Usage: 54.1 MB, less than 65.16% of Java online submissions for Replace Elements with Greatest Element on Right Side.
     *
     * @param arr
     * @return
     */
    public static int[] replaceElements1(int[] arr) {
        int[] newArray = new int[arr.length];
        int maxElement;
        if (arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                maxElement = -1;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > maxElement) {
                        maxElement = arr[j];
                    }
                    newArray[i] = maxElement;
                }
            }
        }
        newArray[arr.length - 1] = -1;
        return newArray;
    }
}