package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PlusOne_66 {
    /**
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Incrementing by one gives 123 + 1 = 124.
     * Thus, the result should be [1,2,4].
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 6})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{5})));
        System.out.println(Arrays.toString(plusOne(new int[]{5, 6, 2, 0, 0, 4, 6, 2, 4, 9})));
    }

    /**
     * Time O(n)
     * space O(n)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
     * Memory Usage: 42.5 MB, less than 43.21% of Java online submissions for Plus One.
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        //if the code get here that is mean the array consist of 9's
        // the new array is initialized by default with 0
        int[] newDigits = new int[length+1];
        newDigits[0] = 1;
        return newDigits;
    }

    /**
     * BruteForce : not working (Overflow)
     *
     * @param digits
     * @return
     */
    public static int[] plusOne1(int[] digits) {
        if (digits.length == 1 && digits[0] == 9) {
            return new int[]{1, 0};
        }
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        }

        long fullNumber = convertArrayToNumber(digits);
        fullNumber++;
        return convertNumberToArray(fullNumber);
//        return new int[]{};
    }

    private static int[] convertNumberToArray(long fullNumber) {
        long copyNumber = fullNumber;
        int numberOfDigits = 0;
        while (copyNumber > 0) {
            copyNumber /= 10;
            numberOfDigits++;
        }
        System.out.println(numberOfDigits);
        int[] newDigits = new int[numberOfDigits];
        for (int i = numberOfDigits - 1; i >= 0; i--) {
            newDigits[i] = (int) (fullNumber % 10);
            fullNumber /= 10;
        }
        return newDigits;
    }

    private static long convertArrayToNumber(int[] digits) {
        long number = 0;
        for (int digit : digits) {
            number = (number * 10) + digit;
        }
        return number;
    }
}
