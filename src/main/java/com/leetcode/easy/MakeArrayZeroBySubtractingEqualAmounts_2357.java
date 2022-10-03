package com.leetcode.easy;

import java.util.*;

public class MakeArrayZeroBySubtractingEqualAmounts_2357 {

    /*
    Runtime: 1 ms, faster than 97.22% of Java online submissions for Make Array Zero by Subtracting Equal Amounts.
    Memory Usage: 40 MB, less than 90.36% of Java online submissions for Make Array Zero by Subtracting Equal Amounts.
     */
    public int minimumOperations(int[] nums) {
        // if there are duplicate number that mean one operation
        Set<Integer> set = new HashSet<>();
        for(int number : nums){
            if(number != 0)
                set.add(number);
        }


        return set.size();
    }
}
