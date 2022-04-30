package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays_349 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    /**
     * Time O(N)
     * Space O(N)
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> intersect = new HashSet<>();
        int firstPointer = 0, secondPointer = 0;
        while (firstPointer < nums1.length && secondPointer < nums2.length) {
            if (nums1[firstPointer] == nums2[secondPointer]) {
                intersect.add(nums1[firstPointer]);
                firstPointer++;
                secondPointer++;
            } else if (nums1[firstPointer] < nums2[secondPointer]) {
                firstPointer++;
            } else {
                secondPointer++;
            }

        }
//        int[] commonElements = new int[intersect.size()];
//        int counter = 0;
//        for (int number : intersect) {
//            commonElements[counter++] = number;
//        }
//        return commonElements;
        return intersect.stream().mapToInt(k -> k).toArray();
    }


    /**
     * Using BinarySearch
     * Time O(N log N)
     * Space O(N)
     *
     * @param nums1
     * @param nums2
     * @return
     */

    public static int[] intersection1(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Set<Integer> intersect = new HashSet<>();
        for (int num : nums2) {
            if (binarySearch(nums1, 0, nums1.length - 1, num))
                intersect.add(num);
        }
        int[] commonElements = new int[intersect.size()];
        int counter = 0;
        for (int number : intersect) {
            commonElements[counter++] = number;
        }
        return commonElements;
    }

    private static boolean binarySearch(int[] arr, int left, int right, int element) {
        if (left > right)
            return false;

        int mid = left + ((right - left) >> 1);
        ;
        if (arr[mid] == element)
            return true;
        else if (arr[mid] > element)
            return binarySearch(arr, left, mid - 1, element);
        else {
            return binarySearch(arr, mid + 1, right, element);
        }

    }


    /**
     * Runtime: 2 ms, faster than 93.55% of Java online submissions for Intersection of Two Arrays.
     * Memory Usage: 42.4 MB, less than 82.58% of Java online submissions for Intersection of Two Arrays.
     *
     * @param nums1
     * @param nums2
     * @return
     */

    public static int[] intersection3(int[] nums1, int[] nums2) {

        Set<Integer> firstSet = new HashSet<>();
        for (int number : nums1)
            firstSet.add(number);

        Set<Integer> intersect = new HashSet<>();
        for (int number : nums2) {
            if (firstSet.contains(number))
                intersect.add(number);
        }

        int[] commonElements = new int[intersect.size()];
        int counter = 0;
        for (int number : intersect) {
            commonElements[counter++] = number;
        }
        return commonElements;
    }


    /**
     * using Two Sets
     * Runtime: 4 ms, faster than 62.71% of Java online submissions for Intersection of Two Arrays.
     * Memory Usage: 44.5 MB, less than 12.03% of Java online submissions for Intersection of Two Arrays.
     * Time O(N^2)
     * Space O(N+m)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {

        Set<Integer> firstSet = new HashSet<>();
        for (int number : nums1)
            firstSet.add(number);

        Set<Integer> secondSet = new HashSet<>();
        for (int number : nums2)
            secondSet.add(number);
        secondSet.retainAll(firstSet);

        int[] commonElements = new int[secondSet.size()];
        int counter = 0;
        for (int number : secondSet) {
            commonElements[counter++] = number;
        }
        return commonElements;
    }
}
