package com.leetcode.medium;

import java.util.*;

//https://leetcode.com/problems/course-schedule/
public class CourseSchedule_207 {
    /**
     * Runtime: 8 ms, faster than 60.70% of Java online submissions for Course Schedule.
     * Memory Usage: 42.2 MB, less than 99.13% of Java online submissions for Course Schedule.
     */
    public boolean canFinish(int vertices, int[][] edges) {
        if (vertices == 0)
            return true;
        // (1) first we need to build Graph
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            // all vertices numbered from 0 to n
            inDegree.put(i, 0); // initialize all vertices with 0 degree
            graph.put(i, new ArrayList<>());
        }

        // (2) build Graph (connect each vertex with edges
        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0], child = edges[i][1];
            inDegree.put(child, inDegree.get(child) + 1);
            graph.get(parent).add(child);
        }

        // (3) Get All Sources Only To Iterate over them only
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        int counter = 0;
        while (!sources.isEmpty()) {
            Integer currentSource = sources.poll();
            counter++;
            List<Integer> currentChildren = graph.get(currentSource);
            for (int child : currentChildren) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sources.add(child);
            }
        }

        return counter == vertices;
    }

    /**
     * Runtime: 3 ms, faster than 97.80% of Java online submissions for Course Schedule.
     * Memory Usage: 42.2 MB, less than 98.08% of Java online submissions for Course Schedule.
     */
    public boolean canFinish2(int n, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        int[] inDegree = new int[n];
        ArrayList<Integer> sources = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        for (int[] e : prerequisites) {
            graph[e[1]].add(e[0]);
            inDegree[e[0]]++;
        }
        for (int i = 0; i < n; ++i)
            if (inDegree[i] == 0) sources.add(i);

        for (int i = 0; i < sources.size(); ++i)
            for (int j : graph[sources.get(i)])
                if (--inDegree[j] == 0)
                    sources.add(j);
        return sources.size() == n;
    }
}
