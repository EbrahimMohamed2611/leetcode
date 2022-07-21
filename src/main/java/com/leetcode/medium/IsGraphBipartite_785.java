package com.leetcode.medium;

import java.util.*;

// https://leetcode.com/problems/is-graph-bipartite/
public class IsGraphBipartite_785 {
    // First using BFS
    /**
     * Runtime: 1 ms, faster than 88.90% of Java online submissions for Is Graph Bipartite?.
     * Memory Usage: 53.6 MB, less than 63.60% of Java online submissions for Is Graph Bipartite?.
     */
    enum Color {READ, BLACK}

    public boolean isBipartite(int[][] adjacencyList) {
        int v = adjacencyList.length;
        Color[] colors = new Color[v];
        for (int i = 0; i < v; i++)
            if (colors[i] == null)
                if (!isBipartite(i, adjacencyList, colors))
                    return false;
        return true;
    }


    private static boolean isBipartite(int node, int[][] adjacencyList, Color[] colors) {
        colors[node] = Color.READ;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            for (int neighbour : adjacencyList[currentNode]) {
                if (colors[neighbour] == null) {
                    colors[neighbour] = (colors[currentNode] == Color.READ) ? Color.BLACK : Color.READ;
                    queue.add(neighbour);
                } else if (colors[neighbour] == colors[currentNode]) {
                    return false;
                }
            }
        }
        return true;
    }
}
