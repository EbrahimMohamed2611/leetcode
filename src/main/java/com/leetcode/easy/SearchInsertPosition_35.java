package com.leetcode.easy;

/**
 * https://leetcode.com/problems/search-insert-position/
 * Amazone
 */
public class SearchInsertPosition_35 {
    /**
     * Time Log(N)
     * Space O(1)
     *Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
     * Memory Usage: 43.3 MB, less than 54.23% of Java online submissions for Search Insert Position.
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int mid = 0;
        while(right >= left){
            mid = left + ((right-left)>>1);
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                right = mid-1;
            else
                left = mid+1;
        }
        return right+1;

    }
}
