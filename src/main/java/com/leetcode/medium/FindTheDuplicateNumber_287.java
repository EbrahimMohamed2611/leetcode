package com.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber_287 {

    /*
    Runtime: 4 ms, faster than 96.13% of Java online submissions for Find the Duplicate Number.
    Memory Usage: 59.3 MB, less than 98.49% of Java online submissions for Find the Duplicate Number.
     */
    public static int findDuplicate3(int[] nums){
        int slow =0, fast = 0;
        do{
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        }while (slow != fast);

        fast = 0;
        while (fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow; // note that the pointer stored the actual value
    }
    /*
    Runtime: 4 ms, faster than 96.13% of Java online submissions for Find the Duplicate Number.
    Memory Usage: 77.9 MB, less than 17.06% of Java online submissions for Find the Duplicate Number.
    */
    public int findDuplicate(int[] nums) {
        int[] freq = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (++freq[nums[i]] > 1)
                return nums[i];
        }
        return -1;
    }

    /*
    Runtime: 17 ms, faster than 38.83% of Java online submissions for Find the Duplicate Number.
    Memory Usage: 60.3 MB, less than 87.81% of Java online submissions for Find the Duplicate Number.
     */
    public int findDuplicate2(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++)
            if (!set.add(A[i]))
                return A[i];
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate3(new int[]{1,3,4,2,2}));
    }


}
