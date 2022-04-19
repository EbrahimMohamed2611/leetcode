package com.leetcode.easy;

/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */

public class FindNumbersWithEvenNumberOfDigits_1295 {
    public static void main(String[] args) {
        int[] numbers = {12,345,2,6,7896};
        System.out.println(findNumbers(numbers));

    }

    /**
     * Runtime: 1 ms, faster than 98.96% of Java online submissions for Find Numbers with Even Number of Digits.
     * Memory Usage: 41.5 MB, less than 94.45% of Java online submissions for Find Numbers with Even Number of Digits.
     *
     * @param nums
     * @return
     */
    public static int findNumbers2(int[] nums) {
        int counter = 0;
        for (int number : nums) {
            if (String.valueOf(number).length() % 2 == 0)
                counter++;
        }
        return counter;
    }


    /**
     * Runtime: 1 ms, faster than 98.96% of Java online submissions for Find Numbers with Even Number of Digits.
     * Memory Usage: 42.2 MB, less than 76.50% of Java online submissions for Find Numbers with Even Number of Digits.
     * @param nums
     * @return
     */
    public static int findNumbers(int[] nums) {
        int counter = 0;
        for (int number : nums) {
            if (isNumberOfValuesEven(number))
                counter++;
        }
        return counter;
    }
    private static boolean isNumberOfValuesEven(int n){
        int count = 0;
        while(n > 0){
            n = n/10;
            count++;

        }
        return count % 2 == 0;
    }
}
