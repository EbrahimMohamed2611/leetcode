package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree_543 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
     * Memory Usage: 41.9 MB, less than 94.70% of Java online submissions for Diameter of Binary Tree.
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];

        findDiameter(root, diameter);
        return diameter[0];
    }
    private static int findDiameter(TreeNode root,int[] diameter) {
        if (root == null) return 0;

        int leftHeight = findDiameter(root.left, diameter);
        int rightHeight = findDiameter(root.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight)+1;
    }
}
