package com.leetcode.medium;

public class RotateImage_48 {
    /*
  Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
  Memory Usage: 40.5 MB, less than 99.76% of Java online submissions for Rotate Image.
  */
    public void rotate(int[][] matrix) {
        //first we can transpose the matrix
        // second will reverse from left with right
        int size = matrix.length;
        for(int i = 0; i < size; i++){
            for(int j =i; j < size; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // then we need to reverse the matrix
        for(int i = 0; i < size; i++){
            for(int j =0; j < size/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size-1-j];
                matrix[i][size-1-j] = temp;
            }
        }

    }
}
