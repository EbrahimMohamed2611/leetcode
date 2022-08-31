package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

public class ValidateBinarySearchTree_98 {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
    Memory Usage: 43.6 MB, less than 68.11% of Java online submissions for Validate Binary Search Tree.
     */
    public boolean isValidBST(TreeNode root) {
        return isBinarySearchTreeHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isBinarySearchTreeHelper(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        if (!(root.val > minValue && root.val < maxValue))
            return false;

        return (isBinarySearchTreeHelper(root.left, minValue, root.val)
                && isBinarySearchTreeHelper(root.right, root.val, maxValue));

    }
}
