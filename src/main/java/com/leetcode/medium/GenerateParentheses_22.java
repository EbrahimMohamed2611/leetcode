package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    /*
    Runtime: 1 ms, faster than 97.74% of Java online submissions for Generate Parentheses.
    Memory Usage: 43.3 MB, less than 77.99% of Java online submissions for Generate Parentheses.
     */
    public static List<String> generateParenthesis(int n) {
        List<String> allParenthesis = new ArrayList<>();
        generateParenthesis(allParenthesis,0,0,n, new StringBuilder());
        return allParenthesis;
    }

    private static void generateParenthesis(List<String> allParenthesis, int openSize, int closeSize, int numberOfParenthesis, StringBuilder paren) {
        if(openSize == numberOfParenthesis && numberOfParenthesis == closeSize){
            allParenthesis.add(new String(paren));
        }

        if(openSize < numberOfParenthesis){
            paren.append("(");
            generateParenthesis(allParenthesis, openSize+1,closeSize,numberOfParenthesis,paren);
            paren.deleteCharAt(paren.length()-1);
        }
        if(closeSize < openSize){
            paren.append(")");
            generateParenthesis(allParenthesis, openSize,closeSize+1,numberOfParenthesis,paren);
            paren.deleteCharAt(paren.length()-1);
        }
    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(1));
    }
}
