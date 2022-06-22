package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections_986 {


    /**
     * Runtime: 2 ms, faster than 99.95% of Java online submissions for Interval List Intersections.
     * Memory Usage: 42.7 MB, less than 99.54% of Java online submissions for Interval List Intersections.
     * @param firstList
     * @param secondList
     * @return
     */
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersected = new ArrayList<>();
        int firstIntervalPointer = 0;
        int secondIntervalPointer = 0;
        while (firstIntervalPointer < firstList.length && secondIntervalPointer < secondList.length) {
            int firstIntervalStart = firstList[firstIntervalPointer][0];
            int firstIntervalEnd = firstList[firstIntervalPointer][1];

            int secondIntervalStart = secondList[secondIntervalPointer][0];
            int secondIntervalEnd = secondList[secondIntervalPointer][1];

            if (secondIntervalStart >= firstIntervalStart && firstIntervalEnd >= secondIntervalStart
                    || firstIntervalStart >= secondIntervalStart && secondIntervalEnd >= firstIntervalStart) {
                intersected.add(new int[]{Math.max(firstIntervalStart, secondIntervalStart), Math.min(secondIntervalEnd, firstIntervalEnd)});
            }
            if (firstIntervalEnd < secondIntervalEnd)
                firstIntervalPointer++;
            else
                secondIntervalPointer++;


        }
        return intersected.toArray(new int[intersected.size()][]);
    }


    /**
     * Runtime: 3 ms, faster than 96.99% of Java online submissions for Interval List Intersections.
     * Memory Usage: 43.3 MB, less than 83.12% of Java online submissions for Interval List Intersections.
     * @param firstList
     * @param secondList
     * @return
     */

    public static int[][] intervalIntersection2(int[][] firstList, int[][] secondList) {
        List<int[]> intersection = new ArrayList<>();
        int firstPointer = 0, secondPointer = 0;
        while (firstPointer < firstList.length && secondPointer < secondList.length) {

            int start = Math.max(secondList[secondPointer][0], firstList[firstPointer][0]);
            int end = Math.min(secondList[secondPointer][1], firstList[firstPointer][1]);


            if (start <= end)
                intersection.add(new int[]{start, end});

            if (secondList[secondPointer][1] > firstList[firstPointer][1])
                firstPointer++;
            else
                secondPointer++;
        }
        return intersection.toArray(new int[intersection.size()][]);
    }

    public static void main(String[] args) {
        /**
         * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
         * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
         */
        System.out.println(Arrays.deepToString(intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}})));
    }
}
