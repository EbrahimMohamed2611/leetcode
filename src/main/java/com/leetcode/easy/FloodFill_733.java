package com.leetcode.easy;

public class FloodFill_733 {
    /*
    Runtime: 1 ms, faster than 90.98% of Java online submissions for Flood Fill.
    Memory Usage: 48.4 MB, less than 22.50% of Java online submissions for Flood Fill.
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        int initialColor = image[sr][sc];
        if (initialColor != color)
            dfs(image, sr, sc, initialColor, color, deltaRow, deltaCol);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int initialColor, int newColor, int[] deltaRow, int[] deltaCol) {

        image[row][col] = newColor;
        int rowSize = image.length;
        int colSize = image[0].length;

        for (int i = 0; i < 4; i++) {
            int newRow = row + deltaRow[i];
            int newCol = col + deltaCol[i];
            if (newRow >= 0 && newRow < rowSize
                    && newCol >= 0 && newCol < colSize && image[newRow][newCol] == initialColor)
                dfs(image, newRow, newCol, initialColor, newColor, deltaRow, deltaCol);
        }

    }
}
