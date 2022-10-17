package com.leetcode.easy;

public class ExcelSheetColumnNumber_171 {
    /*
    Runtime: 2 ms, faster than 81.99% of Java online submissions for Excel Sheet Column Number.
Memory Usage: 43.2 MB, less than 12.54% of Java online submissions for Excel Sheet Column Number.
     */
    public int titleToNumber(String columnTitle) {
        int columnNumber = 0;
        for (char ch : columnTitle.toCharArray()) {

            columnNumber *= 26;
            columnNumber += (ch - 'A') + 1;
        }
        return columnNumber;
    }
}
