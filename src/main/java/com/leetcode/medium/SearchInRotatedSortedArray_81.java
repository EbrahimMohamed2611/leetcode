package com.leetcode.medium;

public class SearchInRotatedSortedArray_81 {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array II.
Memory Usage: 42.2 MB, less than 90.26% of Java online submissions for Search in Rotated Sorted Array II.
     */
    public boolean search(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (end >= start) {
            mid = start + (end - start) / 2;
            if (arr[mid] == k) return true;
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start++;
                end--;
            } else {
                if (arr[mid] >= arr[start]) {
                    if (arr[start] <= k && k <= arr[mid])
                        end = mid - 1;
                    else
                        start = mid + 1;
                } else {

                    if (arr[mid] <= k && k <= arr[end])
                        start = mid + 1;
                    else
                        end = mid - 1;
                }

            }
        }
        return false;
    }
}
