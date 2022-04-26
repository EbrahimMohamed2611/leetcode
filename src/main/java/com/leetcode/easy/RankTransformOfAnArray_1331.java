package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/rank-transform-of-an-array/
 */

public class RankTransformOfAnArray_1331 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{40, 10, 20, 30})));
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12})));
    }

    /**
     * Shorter version
     */
    public static int[] arrayRankTransform2(int[] arr){
        int[] copyOriginal = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copyOriginal);
        HashMap<Integer, Integer> NumberWithRank = new HashMap<>();

        for (int x : copyOriginal)
            NumberWithRank.putIfAbsent(x, NumberWithRank.size() + 1);

        for (int i = 0; i < arr.length; ++i)
            copyOriginal[i] = NumberWithRank.get(arr[i]);

        return copyOriginal;
    }

    /**
     * Using HashMap
     * Input: arr = [40,10,20,30]
     * Output: [4,1,2,3]
     *Time O(N)
     * @param arr
     * @return
     */
    public static int[] arrayRankTransform(int[] arr) {
        // 10 20 30 40

        // (1) Copy The original array to new Array
        // Time O(N)  Space O(N)
        int[] copyArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            copyArray[i] = arr[i];
        // Time O(N logN)  Space O(N)
        Arrays.sort(copyArray);
        //(1) Using HashMap
        // Time O(N)   Space O(N)
        Map<Integer, Integer> numberWithRank = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < arr.length; i++) {
            if(!numberWithRank.containsKey(copyArray[i]))
                numberWithRank.put(copyArray[i],rank++);
        }

        //Time O(N)
        for (int i = 0; i < copyArray.length; i++) {
            arr[i] = numberWithRank.get(arr[i]);
        }
        return arr;
    }

}
