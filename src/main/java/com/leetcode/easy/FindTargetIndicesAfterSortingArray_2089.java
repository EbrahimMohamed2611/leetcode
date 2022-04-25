package com.leetcode.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/find-target-indices-after-sorting-array/
 */
public class FindTargetIndicesAfterSortingArray_2089 {
    public static void main(String[] args) {
        System.out.println(targetIndices(new int[]{1,2,5,2,3},2 ));
        System.out.println(targetIndices(new int[]{1,2,5,2,3},3 ));
        System.out.println(targetIndices(new int[]{1,2,5,2,3},5 ));
        System.out.println(targetIndices(new int[]{100,1,100},100 ));
        System.out.println(targetIndices(new int[]{1,2,5,2,3},4 ));
    }


    /**
     * Time O(N)
     * Space O(1)
     * Runtime: 1 ms, faster than 96.25% of Java online submissions for Find Target Indices After Sorting Array.
     * Memory Usage: 42 MB, less than 99.05% of Java online submissions for Find Target Indices After Sorting Array.
     */


    public static  List<Integer> targetIndices(int[] nums, int target) {
        int smaller = 0;
        int equal = 0;
        for (int num : nums) {
            if (num < target) {
                smaller++;
            } else if (num == target) {
                equal++;
            }
        }
        List<Integer> indices = new ArrayList<>(equal);
        for (int i = smaller; i < smaller + equal; i++) {
            indices.add(i);
        }
        return indices;
    }

    /**
     * Time O(N)
     * Space O(1)
     * Runtime: 2 ms, faster than 78.78% of Java online submissions for Find Target Indices After Sorting Array.
     * Memory Usage: 42.6 MB, less than 80.74% of Java online submissions for Find Target Indices After Sorting Array.
     * @param nums
     * @param target
     * @return
     */
    public static List<Integer> targetIndices2(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> positions = new ArrayList<>();
        int firstOccurrence = firstOrLastOccurrence(nums, target, true);
        int lastOccurrence = firstOrLastOccurrence(nums, target, false);
        if(firstOccurrence == -1){
            return positions;
        }
        for (int i = firstOccurrence; i <= lastOccurrence; i++) {
            positions.add(i);
        }
      return positions;
    }
    private static int firstOrLastOccurrence(int[] numbers, int element, boolean isFirst) {
        int left = 0, right = numbers.length - 1, occurrencePosition = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] == element) {
                // for first occurrence
                if (isFirst) {
                    occurrencePosition = mid;
                    right = mid - 1;
                } else {
                    occurrencePosition = mid;
                    left = mid + 1;
                }
            } else if (numbers[mid] < element) {
                left = mid + 1;
            } else {
                right = mid - 1;

            }
        }
        return occurrencePosition;
    }
}
