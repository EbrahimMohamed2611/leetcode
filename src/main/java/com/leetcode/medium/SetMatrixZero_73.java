package com.leetcode.medium;
/**
 * Companies [ Amazon Microsoft]
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZero_73 {
    /**
     * Time O(N^2)
     * Space O(M+N)
     * Runtime: 1 ms, faster than 89.88% of Java online submissions for Set Matrix Zeroes.
     * Memory Usage: 53.4 MB, less than 67.94% of Java online submissions for Set Matrix Zeroes.
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        int[] extraRow = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            extraRow[i] = -1;
        }
        int[] extraColumn = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            extraColumn[i] = -1;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    extraRow[i] = 0;
                    extraColumn[j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (extraRow[i] == 0 || extraColumn[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Brute force
     * Time (i * j +k+L)
     * Space ON*m)
     * Runtime: 1 ms, faster than 89.88% of Java online submissions for Set Matrix Zeroes.
     * Memory Usage: 54.4 MB, less than 27.36% of Java online submissions for Set Matrix Zeroes.
     *
     * @param matrix
     */
    public static void setZeroes2(int[][] matrix) {
        int rowSize = matrix.length, columnSize = matrix[0].length;
        int[][] copyMatrix = new int[rowSize][columnSize];

        // first we will copy the original matrix to copy matrix
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                copyMatrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (matrix[i][j] == 0) {
                    //                  column size not row size
                    for (int k = 0; k < columnSize; k++)
                        copyMatrix[i][k] = 0;
                    //                 row size not column size
                    for (int l = 0; l < rowSize; l++)
                        copyMatrix[l][j] = 0;

                }
            }
        }

        // move new values to original Matrix
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                //Tricky Part
                if (matrix[i][j] != 0 && copyMatrix[i][j] != 0)
                    continue;
                matrix[i][j] = copyMatrix[i][j];
            }
        }
//        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        //  3 * 4
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        int[][] matrix2 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix3 = {
                {0},
                {1}
        };
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        setZeroes(matrix2);
        System.out.println("############################");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        setZeroes(matrix3);
        System.out.println("############################");
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[i].length; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
//        System.out.println(Arrays.deepToString(matrix));
    }
}
