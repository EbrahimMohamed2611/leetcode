package com.leetcode.easy;

/**
 * https://leetcode.com/problems/remove-element/description/
 */
public class RemoveElement_27 {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 2)); // 2
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2)); // 5
    }



    /**
     * Using Two Pointers first one start from begin and the second start from the end
     * Time O(n)
     * Space O(1)
     Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
     Memory Usage: 42.7 MB, less than 43.16% of Java online submissions for Remove Element.
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int rightPointer = nums.length;

       int leftPointer = 0;

       while (rightPointer > leftPointer){
           if(nums[leftPointer] == val){
               nums[leftPointer] = nums[rightPointer-1];
               rightPointer --;
           }else{
               leftPointer++;
           }
       }
        return leftPointer;
    }


    /**
     * Using Two Pointers start from the same position
     * Time O(n)
     * Space O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
     * Memory Usage: 42.4 MB, less than 57.52% of Java online submissions for Remove Element.
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int leftPointer = 0;

        for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {
            if (nums[rightPointer] != val) {
                nums[leftPointer] = nums[rightPointer];
                leftPointer += 1;
            }
        }
        return leftPointer;
    }

    /**
     * Time O(n^2)
     * Space O(1)
     * Runtime: 1 ms, faster than 27.67% of Java online submissions for Remove Element.
     * Memory Usage: 40.7 MB, less than 92.41% of Java online submissions for Remove Element.
     *
     * @param nums
     * @param val
     * @return
     */

    public static int removeElement2(int[] nums, int val) {
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                if (nums[left] == val && nums[right] != val) {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                }
            }
        }
        int counter = 0;
        for (int num : nums) {
            if (num != val) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }
}