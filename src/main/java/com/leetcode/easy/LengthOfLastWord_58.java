package com.leetcode.easy;

/**
 *https://leetcode.com/problems/length-of-last-word/
 * Companies [ Amazon ]
 */
public class LengthOfLastWord_58 {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
     * Memory Usage: 42.1 MB, less than 54.68% of Java online submissions for Length of Last Word.
     * @param string
     * @return
     */
    public static int lengthOfLastWord(String string) {
        int startIndexFromEnd = string.length()-1;
        for(int i=string.length()-1; i>= 0; i--){
            if(string.charAt(i) != ' '){
                startIndexFromEnd = i;
                break;
            }
        }

        int length = 0;

        for(int i=startIndexFromEnd ; i>= 0; i--){
            if(string.charAt(i) != ' '){
                length++;
            }else{
                break;
            }
        }
        return length;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }
}
