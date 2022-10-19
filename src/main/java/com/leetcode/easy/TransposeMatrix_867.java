package com.leetcode.easy;

public class TransposeMatrix_867 {
        /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Transpose Matrix.
    Memory Usage: 43 MB, less than 91.37% of Java online submissions for Transpose Matrix.
    */
    public int[][] transpose(int[][] matrix) {
        // the matrix not square, so we will create new matrix with inverse dimension (r,c) ==> (c,r)
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int[][] transposedMatrix = new int[colSize][rowSize];
        for(int i = 0; i< rowSize; i++)
            for(int j = 0; j < colSize; j++)
                transposedMatrix[j][i] = matrix[i][j];

        return transposedMatrix;
    }
}
