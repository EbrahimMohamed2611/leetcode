package com.leetcode.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement_169 {
    public static void main(String[] args) {
        int[] numbers = {3,3,4};
        System.out.println(majorityElement(numbers));
        System.out.println(majorityElement2(numbers));
        System.out.println(majorityElement3(numbers));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> numbersWithCounter = new HashMap<>();
        for (int n : nums) {
            Integer orDefault = numbersWithCounter.getOrDefault(n, 0);
            numbersWithCounter.put(n, orDefault + 1);
            if(numbersWithCounter.get(n) > nums.length /2)
                return n;
        }
        return -1;
    }

    /**
     * Runtime: 2 ms, faster than 82.69% of Java online submissions for Majority Element.
     * Memory Usage: 46.1 MB, less than 86.56% of Java online submissions for Majority Element.
     * @param nums
     * @return
     *
     * Time : O(N logN)
     * space: O(1)
     */
    public static int majorityElement2(int[] nums) {
        // O(N log N)
       Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     Runtime: 1 ms, faster than 99.96% of Java online submissions for Majority Element.
     Memory Usage: 46 MB, less than 88.53% of Java online submissions for Majority Element.
     * Time : O(N)
     * space: O(1)
     */
    public static int majorityElement3(int[] nums) {
        // O(N log N)
        int vote = 0, count = 0;
        for (int number :nums) {
            if(count == 0){
                vote = number;
            }
            if(vote == number)
                count++;
            else
                count--;
        }
        return vote;
    }
}
