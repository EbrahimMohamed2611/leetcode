package com.leetcode.easy;

import java.util.*;

public class IntersectionOfTwoArraysII_350 {

    // assuming the arrays are sorted
    /*
    Runtime: 2 ms, faster than 97.19% of Java online submissions for Intersection of Two Arrays II.
    Memory Usage: 42.2 MB, less than 94.44% of Java online submissions for Intersection of Two Arrays II.
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int firstPointer = 0;
        int secondPointer = 0;
        // we need to loop through the second array to get the intersection
        List<Integer> intersectedElements = new ArrayList<>();
        while (firstPointer < nums1.length && secondPointer < nums2.length){
            if(nums1[firstPointer] == nums1[secondPointer]){
                intersectedElements.add(nums1[firstPointer]);
                firstPointer++;
                secondPointer++;
            }else if(nums1[firstPointer]> nums2[secondPointer]){
                // to get the promising number
                secondPointer++;
            }else{
                firstPointer++;
            }
        }
        int[] result = new int[intersectedElements.size()];
        int counter = 0;
        for(int element :intersectedElements)
            result[counter++] = element ;
        return result;
    }

    // Using Map if not sorted and there is one array smaller than other
    /*
    Runtime: 3 ms, faster than 86.64% of Java online submissions for Intersection of Two Arrays II.
    Memory Usage: 42.6 MB, less than 87.75% of Java online submissions for Intersection of Two Arrays II.
    */
    public int[] intersect(int[] nums1, int[] nums2) {
        // since the 2 array one of them is smaller we need to add it ti map
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);
        // add every element in nums1 (smaller array) with frequent
        Map<Integer, Integer> numberWithFreq = new HashMap<>();
        for(int number : nums1)
            numberWithFreq.put(number,numberWithFreq.getOrDefault(number,0)+1 );

        // we need to loop through the second array to get the intersection
        List<Integer> intersectedElements = new ArrayList<>();
        for(int number : nums2){
            if(numberWithFreq.getOrDefault(number,0) > 0){
                intersectedElements.add(number);
                numberWithFreq.put(number,numberWithFreq.get(number)-1);
            }
        }
        int[] result = new int[intersectedElements.size()];
        int counter = 0;
        for(int element :intersectedElements)
            result[counter++] = element ;
        return result;
    }
}
