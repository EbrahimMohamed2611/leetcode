package com.leetcode.easy;

import java.util.Stack;

/**
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'
 * <p>
 * https://leetcode.com/problems/valid-parentheses/
 * Input: s = "()[]{}"
 * Output: true
 */
public class ValidParentheses_20 {
    public static final String LEFT_PARENTHESES = "([{";
    public static final String RIGHT_PARENTHESES = ")]}";

    public static void main(String[] args) {
        String s = "()[]{}";
//        String s = "(]";
//        String s = "()";
        System.out.println(isValidV2(s));
    }

    /**
     * Runtime: 4 ms, faster than 23.17% of Java online submissions for Valid Parentheses.
     * Memory Usage: 42.9 MB, less than 5.94% of Java online submissions for Valid Parentheses.
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        int length = s.length();
        Stack<Character> parentheses = new Stack<>();
        for (int i = 0; i < length; i++) {
            char reversedParenthesis = getReversedCharacter(s.charAt(i));
            if (isLeft(s.charAt(i))) {
                parentheses.push(s.charAt(i));
            } else if (parentheses.isEmpty() || (parentheses.pop() != reversedParenthesis)) {
                return false;
            }
        }
        return parentheses.isEmpty();
    }

    public static boolean isLeft(char parenthesis) {
        return LEFT_PARENTHESES.contains(String.valueOf(parenthesis));
    }

    public static char getReversedCharacter(char parenthesis) {
        if (isLeft(parenthesis)) {
            return RIGHT_PARENTHESES.charAt(LEFT_PARENTHESES.indexOf(parenthesis));
        } else {
            return LEFT_PARENTHESES.charAt(RIGHT_PARENTHESES.indexOf(parenthesis));
        }
    }


    /**
     * Runtime: 2 ms, faster than 82.41% of Java online submissions for Valid Parentheses.
     * Memory Usage: 42 MB, less than 60.18% of Java online submissions for Valid Parentheses.
     * @param s
     * @return
     */
    public static boolean isValidV2(String s) {
        //if size is odd parentheses it will be invalid
        if ((s.length() % 2) != 0)
            return false;
        else {
            Stack<Character> p = new Stack<>();
            for (int i = 0; i < s.length(); i++)
                switch (s.charAt(i)) {
                    case '(':
                        p.push(')');
                        break;
                    case '{':
                        p.push('}');
                        break;
                    case '[':
                        p.push(']');
                        break;
                    case ')':
                    case '}':
                    case ']':
                        if (p.isEmpty() || p.pop() != s.charAt(i))
                            return false;
                }
            return p.isEmpty();
        }
    }
}
