package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    /*
        Time Complexity is N! * N
        Space Complexity is N + N

        Runtime: 1 ms, faster than 98.27% of Java online submissions for Permutations.
        Memory Usage: 44.8 MB, less than 40.34% of Java online submissions for Permutations.
         */
    public static  List<List<Integer>> permute(int[] nums){
        List<List<Integer>> allPermutations = new ArrayList<>();
        boolean[] frequencies = new boolean[nums.length];
        getAllPermutation(nums, allPermutations,frequencies, new ArrayList<>());
        return allPermutations;
    }

    private  static void getAllPermutation(int[] nums, List<List<Integer>> permutations, boolean[] freq, List<Integer> currentPermutation) {
        if (currentPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPermutation));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!freq[i]) {
                    freq[i] = true;
                    currentPermutation.add(nums[i]);
                    getAllPermutation(nums, permutations, freq, currentPermutation);
                    currentPermutation.remove(currentPermutation.size() - 1);
                    freq[i] = false;
                }
            }
        }
    }


}
