package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

public class BalancedBinaryTree_110 {

    /**
     * Runtime: 1 ms, faster than 99.02% of Java online submissions for Balanced Binary Tree.
     * Memory Usage: 44.9 MB, less than 14.32% of Java online submissions for Balanced Binary Tree.
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return maximumDepthRecur(root, 0) != -1;
    }

    private static int maximumDepthRecur(TreeNode root, int depth) {
        if (root == null)
            return depth;

        int leftDepth = maximumDepthRecur(root.left, depth + 1);
        int rightDepth = maximumDepthRecur(root.right, depth + 1);
        if (Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        return Math.max(leftDepth, rightDepth);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
//        root.right.right.right = new TreeNode(15);
        System.out.println(isBalanced(root));
    }

}
