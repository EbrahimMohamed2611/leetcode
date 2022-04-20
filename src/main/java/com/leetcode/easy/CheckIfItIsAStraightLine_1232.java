package com.leetcode.easy;

public class CheckIfItIsAStraightLine_1232 {
    public static void main(String[] args) {
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        int[][] coordinates2 = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        System.out.println(checkStraightLine(coordinates));
        System.out.println(checkStraightLine(coordinates2));
    }

    /**
     * Time O(N)
     * Space O(1)
     * Using slop
     * (y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)
     *              xi           yi
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Check If It Is a Straight Line.
     * Memory Usage: 44.4 MB, less than 18.08% of Java online submissions for Check If It Is a Straight Line.
     */
    public static boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length; i++) {
          if((coordinates[1][1] - coordinates[0][1]) * (coordinates[i][0] - coordinates[0][0]) !=
                    (coordinates[1][0] - coordinates[0][0]) * (coordinates[i][1] - coordinates[0][1]))
                return false;
        }
        return true;
    }

}
