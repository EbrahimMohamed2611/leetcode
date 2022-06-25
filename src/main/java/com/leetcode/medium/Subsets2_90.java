package com.leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/subsets-ii/
 * Amazon Facebook
 */
public class Subsets2_90 {
    /**
     * Runtime: 1 ms, faster than 99.97% of Java online submissions for Subsets II.
     * Memory Usage: 42.6 MB, less than 88.92% of Java online submissions for Subsets II.
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subSets = new ArrayList<>();
        Arrays.sort(nums);
        generateSubSets(0,nums,subSets,new ArrayList<>());
        return subSets;
    }
    private void generateSubSets(int index, int[] nums, List<List<Integer>> subSets, List<Integer> list){
        subSets.add(new ArrayList<>(list));

        for(int i = index; i< nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;

            list.add(nums[i]);
            generateSubSets(i+1, nums, subSets, list);
            list.remove(list.size()-1);
        }
    }
}
