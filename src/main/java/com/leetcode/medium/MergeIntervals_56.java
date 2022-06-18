package com.leetcode.medium;

import java.util.*;

public class MergeIntervals_56 {

    /**
     Runtime: 12 ms, faster than 67.95% of Java online submissions for Merge Intervals.
     Memory Usage: 56.3 MB, less than 5.60% of Java online submissions for Merge Intervals.
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0], interval2[0])); // (NLogN)
        if (intervals.length <= 1)
            return intervals;
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) { // Log(N)
            int[] lastInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            if(lastInterval[1] >= intervals[i][0]){
                mergedIntervals.set(mergedIntervals.size() - 1, new int[]{lastInterval[0],Math.max(lastInterval[1], intervals[i][1])});
           }else{
               mergedIntervals.add(new int[]{intervals[i][0], intervals[i][1]});
           }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]); // Log(N)
    }

    public static void main(String[] args) {
        // [[1,3],[2,6],[8,10],[15,18]] ====> [[1,6],[8,10],[15,18]]
        // [[1,4],[4,5]] ====> [[1,5]]
        // [[1,4],[5,6]] ===> [[1,4],[5,6]]
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {5, 6}})));
    }

}
