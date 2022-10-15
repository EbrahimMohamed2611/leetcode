package com.leetcode.easy;

import java.util.*;

public class MeetingRooms_252 {
    /*
    Runtime: 5 ms, faster than 98.14% of Java online submissions for Meeting Rooms.
Memory Usage: 41.8 MB, less than 97.98% of Java online submissions for Meeting Rooms.
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        // System.out.println(Arrays.deepToString(intervals));
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i - 1][1] > intervals[i][0])
                return false;

        return true;
    }
}
