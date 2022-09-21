package com.leetcode.medium;


// https://leetcode.com/problems/find-peak-element/submissions/
// Amazon Apple  Microsoft  Facebook Google Uber Adobe tikTok Bloomberg
public class FindPeakElement_162 {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
    Memory Usage: 42.6 MB, less than 68.71% of Java online submissions for Find Peak Element.
     */
    public int findPeakElement(int[] nums) {
        int low =0, high = nums.length-1;
        int mid;
        while(high > low){
            mid = (high + low) / 2;
            if(nums[mid] > nums[mid +1] && (mid > high) && nums[mid] > nums[mid-1]) // we can use this or not it's optional
                return mid;
            if(nums[mid] > nums[mid +1])
                high = mid;
            else
                low = mid + 1;
        }
        return high;
    }
}
