package com.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/
public class RottingOranges_994 {
    // First using copy of Grid and not altering the original input
    /*
    Runtime: 2 ms, faster than 96.42% of Java online submissions for Rotting Oranges.
    Memory Usage: 41.7 MB, less than 96.98% of Java online submissions for Rotting Oranges.
     */
    public static int orangesRotting(int[][] grid) {
        // 2 => rotten     1 => fresh    0 => no orange
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int[][] visited = new int[rowLength][columnLength];
        Queue<int[]> queue = new LinkedList<>();
        int freshOrangeNumber = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = 2;
                } else if (grid[i][j] == 1) {
                    freshOrangeNumber++;
                    visited[i][j] = 1;
                }
            }
        }

        int freshOrangeRottingNumber = 0;
        int minimumNumber = 0;
        while (!queue.isEmpty()) {
            int[] currentOrange = queue.poll();
            int row = currentOrange[0];
            int col = currentOrange[1];
            int time = currentOrange[2];
            if (grid[row][col] == 1) freshOrangeRottingNumber++;
            // visit all neighbours
            if (row - 1 >= 0 && grid[row - 1][col] == 1 && visited[row - 1][col] == 1) {
                queue.add(new int[]{row - 1, col, time + 1});
                visited[row - 1][col] = 2;
            }

            if (row + 1 < rowLength && grid[row + 1][col] == 1 && visited[row + 1][col] == 1) {
                queue.add(new int[]{row + 1, col, time + 1});
                visited[row + 1][col] = 2;
            }

            if (col - 1 >= 0 && grid[row][col - 1] == 1 && visited[row][col - 1] == 1) {
                queue.add(new int[]{row, col - 1, time + 1});
                visited[row][col - 1] = 2;
            }

            if (col + 1 < columnLength && grid[row][col + 1] == 1 && visited[row][col + 1] == 1) {
                queue.add(new int[]{row, col + 1, time + 1});
                visited[row][col + 1] = 2;
            }
            minimumNumber = time;
        }
        if (freshOrangeNumber != freshOrangeRottingNumber) return -1;

        return minimumNumber;
    }


    /**
     * Runtime: 2 ms, faster than 96.42% of Java online submissions for Rotting Oranges.
     * Memory Usage: 43.5 MB, less than 23.41% of Java online submissions for Rotting Oranges.
     */
    public static int orangesRottingWithSameInput(int[][] grid) {
        // 2 => rotten     1 => fresh    0 => no orange
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOrangeNumber = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                } else if (grid[i][j] == 1) {
                    freshOrangeNumber++;
                }
            }
        }

        int freshOrangeRottingNumber = 0;
        int minimumNumber = 0;
        while (!queue.isEmpty()) {
            int[] currentOrange = queue.poll();
            int row = currentOrange[0];
            int col = currentOrange[1];
            int time = currentOrange[2];
            // visit all neighbours
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                queue.add(new int[]{row - 1, col, time + 1});
                freshOrangeRottingNumber++;
                grid[row - 1][col] = 2;
            }

            if (row + 1 < rowLength && grid[row + 1][col] == 1) {
                queue.add(new int[]{row + 1, col, time + 1});
                freshOrangeRottingNumber++;
                grid[row + 1][col] = 2;
            }

            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                queue.add(new int[]{row, col - 1, time + 1});
                freshOrangeRottingNumber++;
                grid[row][col - 1] = 2;
            }

            if (col + 1 < columnLength && grid[row][col + 1] == 1) {
                queue.add(new int[]{row, col + 1, time + 1});
                freshOrangeRottingNumber++;
                grid[row][col + 1] = 2;
            }
            minimumNumber = time;
        }
        if (freshOrangeNumber != freshOrangeRottingNumber) return -1;

        return minimumNumber;
    }


    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}})); // 4

        System.out.println(orangesRotting(new int[][]{{0, 2}})); // 0

        System.out.println(orangesRottingWithSameInput(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}})); // 4

        System.out.println(orangesRottingWithSameInput(new int[][]{{0, 2}})); // 0
    }
}
