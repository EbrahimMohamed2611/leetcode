package com.leetcode.easy;

/**
 * https://leetcode.com/problems/binary-search/
 * Company Microsoft
 */
public class BinarySearch_704 {
    // Iterative

    /**
     * Time O(LogN)
     * Space O(!)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
     * Memory Usage: 54.5 MB, less than 38.20% of Java online submissions for Binary Search.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int leftPointer = 0, rightPointer = nums.length - 1;
        // leftPointer <= rightPointer and not leftPointer < rightPointer because if we have one number, and we search on it
        while (leftPointer <= rightPointer) {
            int mid = leftPointer + ((rightPointer - leftPointer) >> 1);
            if (nums[mid] == target)
                return mid;

            if (target > nums[mid]) {
                leftPointer = mid + 1;
            } else {
                rightPointer = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Time O(LogN)
     *Space O(!)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
     * Memory Usage: 53.9 MB, less than 63.42% of Java online submissions for Binary Search.
     * @param nums
     * @param target
     * @return
     */
    public static int search2(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private static int binarySearch(int[] nums, int target, int left, int right) {
        if (right < left)
            return -1;
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == target)
            return mid;
        if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        } else {
            return binarySearch(nums, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9)); // 4
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2)); // -1
        System.out.println(search(new int[]{5}, 5)); // -1
        System.out.println(search2(new int[]{-1, 0, 3, 5, 9, 12}, 9)); // 4
        System.out.println(search2(new int[]{-1, 0, 3, 5, 9, 12}, 2)); // -1
        System.out.println(search2(new int[]{5}, 5)); // -1
    }

}
