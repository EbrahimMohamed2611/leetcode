package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

public class PathSum_112 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
     * Memory Usage: 42.3 MB, less than 86.07% of Java online submissions for Path Sum.
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null)
            return false;

        if ((sum - root.val == 0) && isLeaf(root))
            return true;
        boolean leftView = hasPathSum(root.left, sum - root.val);
        boolean rightView = hasPathSum(root.right, sum - root.val);
        return leftView || rightView;
    }

    private static boolean isLeaf(TreeNode node) {
        return node.right == null && node.left == null;
    }
}
