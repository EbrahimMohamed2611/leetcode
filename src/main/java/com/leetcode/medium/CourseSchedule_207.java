package com.leetcode.medium;

import java.util.*;

//https://leetcode.com/problems/course-schedule/
public class CourseSchedule_207 {
    /**
     * Runtime: 2 ms, faster than 100.00% of Java online submissions for Course Schedule.
     * Memory Usage: 42.3 MB, less than 96.81% of Java online submissions for Course Schedule.
     */
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            adjacencyList.add(i, new ArrayList<Integer>());

        buildAdjacencyList(adjacencyList, prerequisites);
        boolean[] visited = new boolean[n];
        boolean[] visiting = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                if (isGraphContainCycle(node, adjacencyList, visited, visiting))
                    return false;
            }
        }
        return true;
    }

    private static boolean isGraphContainCycle(int node, List<List<Integer>> adjacencyList, boolean[] visited, boolean[] visiting) {
        visited[node] = true;
        visiting[node] = true;
        for (int neighbour : adjacencyList.get(node)) {
            if (!visited[neighbour]) {
                if (isGraphContainCycle(neighbour, adjacencyList, visited, visiting))
                    return true;
            } else if (visiting[neighbour])
                return true;
        }
        visiting[node] = false;
        return false;
    }

    private static void buildAdjacencyList(List<List<Integer>> adjacencyList, int[][] prerequisites) {
        for (int[] i : prerequisites) {
            adjacencyList.get(i[0]).add(i[1]);
        }
    }
}
