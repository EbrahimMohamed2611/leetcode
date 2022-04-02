package com.leetcode.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * Runtime: 6 ms, faster than 99.96% of Java online submissions for Palindrome Number.
 * Memory Usage: 41.6 MB, less than 91.44% of Java online submissions for Palindrome Number.
 */
public class PalindromeNumber_9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        else {
            int reversedNumber = 0, originalNumber = x;
            while (x > 0) {
                reversedNumber = (x % 10) + (reversedNumber * 10);
                x /= 10;
            }
            return reversedNumber == originalNumber;
        }
    }

//    private static boolean isPalindrome(int x){
//        return new StringBuilder(String.valueOf(x)).reverse().toString().equals(String.valueOf(x));
//
//    }
}
