package com.leetcode.medium;

import java.util.Arrays;

public class SortColors_75 {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
    Memory Usage: 40.5 MB, less than 98.64% of Java online submissions for Sort Colors.
     */
    public void sortColors(int[] nums) {
        int zeroPointer = 0, onePointer = 0, twoPointer = nums.length - 1;
        while (onePointer <= twoPointer) {
            int currentElement = nums[onePointer];
            switch (currentElement) {
                case 0: {
                    swap(nums, zeroPointer, onePointer);
                    zeroPointer++;
                    onePointer++;
                    break;
                }
                case 1: {
                    onePointer++;
                    break;
                }
                case 2: {
                    swap(nums, onePointer, twoPointer); // [1,2,0] this case to prove we cannot increase onePointer
                    twoPointer--;
                    break;
                }
            }
        }
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
    Memory Usage: 41.9 MB, less than 83.67% of Java online submissions for Sort Colors.
     */
    public static void sortColors2(int[] nums) {
        int zeroCounter = 0, oneCounter = 0, twoCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    zeroCounter++;
                    break;
                case 1:
                    oneCounter++;
                    break;
                case 2:
                    twoCounter++;
                    break;
            }
        }
        int i =0;
        for (; i < zeroCounter; i++)
            nums[i] = 0;

        for (; i < oneCounter + zeroCounter; i++)
            nums[i] = 1;

        for (; i < nums.length; i++)
            nums[i] = 2;

    }

    private void swap(int[] nums, int zeroPointer, int onePointer) {
        int temp = nums[zeroPointer];
        nums[zeroPointer] = nums[onePointer];
        nums[onePointer] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {1,0,0,2,2,1,0,1,2};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
