package com.leetcode.medium;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        // Time: O(N)3
        //Space: O(1)
        /*
        Runtime: 3 ms, faster than 97.88% of Java online submissions for Container With Most Water.
        Memory Usage: 52.8 MB, less than 89.58% of Java online submissions for Container With Most Water.
        */
        int left = 0, right = height.length -1;
        int maxArea = 0;
        while(right > left){
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;

        // int maxArea = 0;
        // for(int i = 0; i< height.length; i++){
        //     for(int j = i; j < height.length; j++){
        //         maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j -i));
        //     }
        // }
        // return maxArea;

    }
}
