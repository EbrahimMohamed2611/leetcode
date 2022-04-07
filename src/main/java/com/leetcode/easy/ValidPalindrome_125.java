package com.leetcode.easy;


public class ValidPalindrome_125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("ab"));
        System.out.println(isPalindrome("0P"));
    }

    /**
     Runtime: 8 ms, faster than 44.36% of Java online submissions for Valid Palindrome.
     Memory Usage: 43.9 MB, less than 46.53% of Java online submissions for Valid Palindrome.
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        String s1 = s.trim().toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s1.toCharArray()){
//            if(('a'<=c && c<='z') || ('0' <= c && c <= '9'))
            if (Character.isLetterOrDigit(c))
                stringBuilder.append(c);
        }
        int length =stringBuilder.length();
        if(length<=1) return true;
        for (int i = 0; i <= stringBuilder.length()/2; i++) {
            if(stringBuilder.charAt(i) != stringBuilder.charAt(--length))
                return false;
        }
        return true;
    }
}
