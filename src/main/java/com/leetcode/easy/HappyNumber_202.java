package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber_202 {
    private static final List<Integer> NUMBER_CYCLE = Arrays.asList(2, 4, 16, 37, 58, 89, 145, 42, 20);


    /**
     Runtime: 1 ms, faster than 97.89% of Java online submissions for Happy Number.
     Memory Usage: 41 MB, less than 64.86% of Java online submissions for Happy Number.
     * using numbers the causes cycle hardcoded
     * @param n
     * @return
     */
    public static boolean isHappy2(int n) {
        while (n != 1) {
            if(NUMBER_CYCLE.contains(n))
                return false;
            n = sum(n);
        }
        return true;
    }

    /**
     * using slow fast pointers to detect cycle
     * Runtime: 1 ms, faster than 97.89% of Java online submissions for Happy Number.
     * Memory Usage: 38.9 MB, less than 99.90% of Java online submissions for Happy Number.
     *
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        int slowPointer = n, fastPointer = n;
        do {
            slowPointer = sum(slowPointer);
            fastPointer = sum(sum(fastPointer));
        } while (slowPointer != fastPointer);

        return slowPointer == 1;
    }


    /**
     * using HashSet
     Runtime: 2 ms, faster than 61.30% of Java online submissions for Happy Number.
     Memory Usage: 41.5 MB, less than 36.33% of Java online submissions for Happy Number.
     */
    public static boolean isHappy3(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1){
            if(!seen.add(n))
                return false;
            n = sum(n);
        }
        return true;
    }

    private static int sum(int number) {
        int sum = 0;
        while (number != 0) {
            int firstDigit = number % 10;
            sum += firstDigit * firstDigit;
            number = (number / 10);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy2(19));
        System.out.println(isHappy3(19));
        System.out.println(28>>5);
    }
}
