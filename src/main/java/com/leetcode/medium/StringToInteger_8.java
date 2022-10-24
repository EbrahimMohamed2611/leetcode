package com.leetcode.medium;

import java.util.*;

public class StringToInteger_8 {
        /*
    Runtime: 2 ms, faster than 91.12% of Java online submissions for String to Integer (atoi).
    Memory Usage: 43.9 MB, less than 9.33% of Java online submissions for String to Integer (atoi).
    */


    public static int myAtoi(String s) {
//        List<Character> numberSet = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        long number = 0;
        int positive = 1;
        //(1) leading whitespace
        int pointer = 0;
        while (pointer < s.length() && s.charAt(pointer) == ' ')
            pointer++;
        //(2) '-' or '+'
        if (pointer < s.length() && s.charAt(pointer) == '-') {
            pointer++;
            positive = -1;
        } else if (pointer < s.length() && s.charAt(pointer) == '+')
            pointer++;
        //(3) read the only char and stop when face any non digit
        //(4) convert the final string to number and apply sign
//        while (pointer < s.length() && numberSet.contains(s.charAt(pointer))) {
        while (pointer < s.length() && Character.isDigit(s.charAt(pointer))) {
            number = number * 10 + Integer.parseInt(String.valueOf(s.charAt(pointer++)));
            if (number > Integer.MAX_VALUE)
                break;
        }
        //(5) if bigger than Integer.MAX_VALUE will return the mx and the same thing with min
        number *= positive;
        if (number > 0)
            return (int) Math.min(number, Integer.MAX_VALUE);
        else
            return (int) Math.max(number, Integer.MIN_VALUE);


    }

    public static void main(String[] args) {
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("9223372036854775808"));
        System.out.println(myAtoi("21474836460"));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.valueOf("21474836460"));
    }
}
