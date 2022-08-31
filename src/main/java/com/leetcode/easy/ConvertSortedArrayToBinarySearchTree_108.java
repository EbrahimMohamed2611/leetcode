package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

public class ConvertSortedArrayToBinarySearchTree_108 {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
    Memory Usage: 42.1 MB, less than 97.21% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // start   end
        return buildBST(0,nums.length-1, nums);
    }

    private TreeNode buildBST(int start, int end, int[] nums){
        if(end < start)
            return null;

        int mid = (end + start) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(start, mid-1, nums);
        root.right = buildBST(mid+1, end, nums);

        return root;

    }
}
