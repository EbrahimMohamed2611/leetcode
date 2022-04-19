package com.leetcode.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle_118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    /**
     * Time O(N2)
     * Space O(N)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
     * Memory Usage: 42.2 MB, less than 24.03% of Java online submissions for Pascal's Triangle.
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                // using set method to update the value instead of add
                row.set(j, row.get(j) + row.get(j + 1));
            }
            // using new ArrayList<> for copy the values because we did not need the reference
            pascalTriangle.add(new ArrayList<>(row));
        }
        return pascalTriangle;
    }
}
