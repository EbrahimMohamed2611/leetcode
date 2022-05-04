package com.leetcode.easy;

import java.util.*;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/
 * Constraints:
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * Companies [Google- Amazon- Facebook-Uber-Adobe-Microsoft-Morgan stanley]
 */
public class SortArrayByIncreasingFrequency_1636 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{1, 1, 2, 2, 2, 3}))); // 3,1,1,2,2,2
    }

    static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> numberWithFrequency = new HashMap<>();
        for (int number : nums) {
            if (!numberWithFrequency.containsKey(number))
                numberWithFrequency.put(number, 1);
            else
                numberWithFrequency.put(number, numberWithFrequency.get(number) + 1);
        }

       List<Map.Entry<Integer,Integer>> mapList = new ArrayList<>(numberWithFrequency.entrySet());
        mapList.sort((e1, e2) -> {
            if (Objects.equals(e1.getValue(), e2.getValue()))
                return e2.getKey() - e1.getKey();
            else
                return e1.getValue() - e2.getValue();
        });
        int[] arrays = new int[nums.length];
        int counter =0;
        for (Map.Entry<Integer,Integer> entry : mapList){
            int number = entry.getValue();
            while (number > 0){
                arrays[counter++] = entry.getKey();
                number--;
            }
        }
        return arrays;

    }
}
