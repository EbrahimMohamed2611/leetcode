package com.leetcode.medium;

import java.util.*;

public class CourseSchedule2_210 {
    // Using Topological order (Kahn's algorithm using BFS)

    /**
     Runtime: 5 ms, faster than 91.84% of Java online submissions for Course Schedule II.
     Memory Usage: 43.2 MB, less than 93.28% of Java online submissions for Course Schedule II.
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1)
            return new int[]{0};
        int[] ordered = new int[numCourses]; // courses labeled from 0 to n-1
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
            inDegree[i] = 0;
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree[child]++;
        }

        Queue<Integer> sources = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            int degree = inDegree[i];
            if (degree == 0)
                sources.add(i);
        }
        int index = 0;
        while (!sources.isEmpty()) {
            int currentSource = sources.poll();
            ordered[index++] = currentSource;
            for (int neighbour : graph.get(currentSource))
                if (--inDegree[neighbour] == 0)
                    sources.add(neighbour);
        }

        if (index != numCourses)
            return new int[]{};

        int counter = 0;
        while (counter < ordered.length / 2) {
            int temp = ordered[counter];
            ordered[counter] = ordered[ordered.length - 1 - counter];
            ordered[ordered.length - 1 - counter] = temp;
            counter++;
        }
        return ordered;
    }



    public static void main(String[] args) {
        int[] order = findOrder(4, new int[][]{
                {1, 0}, {2, 0}, {3, 1}, {3, 2}});
        System.out.println(Arrays.toString(order));

        int[] order2 = findOrder(2, new int[][]{
                {1, 0}});
        System.out.println(Arrays.toString(order2));

        int[] order3 = findOrder(1, new int[][]{
        });
        System.out.println(Arrays.toString(order3));
    }
}
