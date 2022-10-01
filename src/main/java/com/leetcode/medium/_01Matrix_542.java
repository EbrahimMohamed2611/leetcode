package com.leetcode.medium;

import java.util.*;

// https://leetcode.com/problems/01-matrix/
// Amazon Bloomberg Google Microsoft  Facebook Apple Uber
public class _01Matrix_542 {

    private class Tuple{
        private int row;
        private int col;
        private int steps;

        public Tuple(int row, int col, int steps){
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    /*
    Runtime: 13 ms, faster than 80.76% of Java online submissions for 01 Matrix.
    Memory Usage: 45.3 MB, less than 93.30% of Java online submissions for 01 Matrix.
     */

    // Without modifying the original array
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        boolean[][] visited = new boolean[r][c];
        int[][] matrix = new int[r][c];
        Queue<Tuple> queue = new LinkedList<>();

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(mat[i][j] == 0){
                    queue.add(new Tuple(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        int[] deltaRow = {-1,0,0,1};
        int[] deltaCol = {0,-1,1,0};

        while(!queue.isEmpty()){
            Tuple current = queue.remove();
            int row = current.row;
            int col = current.col;
            int steps = current.steps;
            matrix[row][col] = steps;
            for(int i=0; i<4;i++){
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];
                if(newRow >=0 && newRow < r && newCol >=0 && newCol < c && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    queue.add(new Tuple(newRow,newCol,steps+1));
                }
            }
        }


        return matrix;
    }

    // with modifying the original array
    public int[][] updateMatrix2(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        boolean[][] visited = new boolean[r][c];
        int[][] matrix = new int[r][c];
        Queue<Tuple> queue = new LinkedList<>();

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(mat[i][j] == 0){
                    queue.add(new Tuple(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        int[] deltaRow = {-1,0,0,1};
        int[] deltaCol = {0,-1,1,0};

        while(!queue.isEmpty()){
            Tuple current = queue.remove();
            int row = current.row;
            int col = current.col;
            int steps = current.steps;
            mat[row][col] = steps;
            for(int i=0; i<4;i++){
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];
                if(newRow >=0 && newRow < r && newCol >=0 && newCol < c && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    queue.add(new Tuple(newRow,newCol,steps+1));
                }
            }
        }


        return mat;
    }
}
