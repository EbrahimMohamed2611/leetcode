package com.leetcode.hard;

import com.leetcode.classes.TreeNode;

public class BinaryTreeMaximumPathSum_124 {
    /*
    Runtime: 1 ms, faster than 99.76% of Java online submissions for Binary Tree Maximum Path Sum.
    Memory Usage: 48.6 MB, less than 8.70% of Java online submissions for Binary Tree Maximum Path Sum.
     */
    public int maxPathSum(TreeNode root) {

        int[] maxPathSum = new int[]{Integer.MIN_VALUE};
        maxPathSumHelper(root, maxPathSum);
        return maxPathSum[0] ;
    }

    private int maxPathSumHelper(TreeNode root, int[] maxPathSum){
        if(root == null)
            return 0;

        int leftPath = Math.max(maxPathSumHelper(root.left, maxPathSum),0);
        int rightPath = Math.max(maxPathSumHelper(root.right, maxPathSum),0);

        maxPathSum[0] = Math.max(maxPathSum[0],leftPath+rightPath+root.val);
        return root.val + Math.max(leftPath, rightPath);
    }
}
