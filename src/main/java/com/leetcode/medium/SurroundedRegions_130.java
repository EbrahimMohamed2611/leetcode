package com.leetcode.medium;

public class SurroundedRegions_130 {

    /*
       Runtime: 1 ms, faster than 99.95% of Java online submissions for Surrounded Regions.
       Memory Usage: 44.4 MB, less than 91.34% of Java online submissions for Surrounded Regions.
       */
    //Time: O(N+M + N*M)
    //Space: O(N*M)
    public void solve(char[][] board) {
        //first we need to invalidate the 'O' with all connected 'O' in all Boundaries
        int rowSize = board.length;
        int colSize = board[0].length;
        boolean[][] visisted = new boolean[rowSize][colSize];
        // construct delta rw column to validate the matrix boundary
        int[] deltaRwo = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        //first: traverse the first row and last row
        for(int i = 0; i < colSize ; i++){
            //first Row
            if(!visisted[0][i] && board[0][i] == 'O')
                dfs(0, i, board, visisted, rowSize, colSize, deltaRwo, deltaCol);
            // Notice the matrix not N*N but M*N (no of row not equal to number col)
            //Last Row
            if(!visisted[rowSize-1][i] && board[rowSize-1][i] == 'O')
                dfs(rowSize-1, i, board, visisted, rowSize, colSize, deltaRwo, deltaCol);
        }
        //second: traverse the first column and last column
        for(int i = 0; i < rowSize; i++){
            //first Column
            if(!visisted[i][0] && board[i][0] == 'O')
                dfs(i, 0, board, visisted, rowSize, colSize, deltaRwo, deltaCol);

            //Last Column
            if(!visisted[i][colSize-1] && board[i][colSize-1] == 'O')
                dfs(i, colSize-1, board, visisted, rowSize, colSize, deltaRwo, deltaCol);
        }

        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j< colSize; j++){
                if(board[i][j] == 'O' && !visisted[i][j])
                    board[i][j] = 'X';
            }
        }

    }

    private void  dfs(int row, int col, char[][] board, boolean[][] visisted, int rowSize, int colSize,int[] delteRwo,int[] delteCol){
        // first mark it as visited
        visisted[row][col] = true;
        for(int i = 0; i < 4; i++){
            int newRow  = row + delteRwo[i];
            int newCol  = col + delteCol[i];
            if(newRow >= 0 && newRow <rowSize && newCol >= 0 && newCol < colSize && !visisted[newRow][newCol] && board[newRow][newCol] == 'O')
                dfs(newRow, newCol, board, visisted, rowSize, colSize, delteRwo, delteCol);
        }
    }
}