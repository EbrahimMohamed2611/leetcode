package com.leetcode.medium;

public class NumberOfProvinces_547 {

    /*
       Runtime: 1 ms, faster than 99.99% of Java online submissions for Number of Provinces.
       Memory Usage: 53.9 MB, less than 63.75% of Java online submissions for Number of Provinces.
        */
    public static int findCircleNum(int[][] adj) {
        int size = adj.length;
        boolean[] visited = new boolean[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                counter++;
                dfs(adj, visited, size, i);
            }
        }
        return counter;
    }

    private static void dfs(int[][] matrix, boolean[] visited, int size, int currentNode) {
        visited[currentNode] = true;
        for (int i = 0; i < size; i++) {
            if (matrix[currentNode][i] == 1 && !visited[i]) {
                dfs(matrix, visited, size, matrix[currentNode][i]);
            }
        }

    }


    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{
                {1,1,0},{1,1,0},{0,0,1}
        })); // 2
        System.out.println(findCircleNum(new int[][]{
                {1,0,0},{0,1,0},{0,0,1}
        })); // 3
    }
}
