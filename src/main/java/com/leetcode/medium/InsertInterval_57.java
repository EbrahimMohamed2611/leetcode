package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval_57 {
    /**
     Runtime: 1 ms, faster than 99.71% of Java online submissions for Insert Interval.
     Memory Usage: 44.8 MB, less than 82.00% of Java online submissions for Insert Interval.
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> insertedIntervals = new ArrayList<>();
        int size = intervals.length;
        int intervalPointer = 0;
        while (intervalPointer < size && intervals[intervalPointer][1] < newInterval[0]) {
            insertedIntervals.add(new int[]{intervals[intervalPointer][0], intervals[intervalPointer++][1]});
        }
        while (intervalPointer < size && intervals[intervalPointer][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[intervalPointer][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[intervalPointer][1]);
            intervalPointer++;
        }
        insertedIntervals.add(newInterval);
        while (intervalPointer < size) {
            insertedIntervals.add(new int[]{intervals[intervalPointer][0], intervals[intervalPointer++][1]});
        }
//        int[][] inserted = new int[insertedIntervals.size()][2];
//        for (int i = 0; i < insertedIntervals.size(); i++) {
//            inserted[i][0] = insertedIntervals.get(i)[0];
//            inserted[i][1] = insertedIntervals.get(i)[1];
//        }
        return insertedIntervals.toArray(new int[insertedIntervals.size()][]);
//        return inserted;
    }

    public static void main(String[] args) {
        //[[1,3],[6,9]], newInterval = [2,5] ===>  [[1,5],[6,9]]
        //[[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8] === >[[1,2],[3,10],[12,16]]
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));

    }
}
