package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

public class FlattenBinaryTreeToLinkedList_114 {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
    Memory Usage: 41.6 MB, less than 98.01% of Java online submissions for Flatten Binary Tree to Linked List.
    */
    public void flatten(TreeNode root) {
        root = helper(root, null);
    }
    // helper function takes in the previous head, do the flattening and returns the head of the flatten binary tree
    private TreeNode helper(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }
        prev = helper(root.right, prev);
        prev = helper(root.left, prev);
        root.right = prev;
        root.left = null;
        prev = root; // also we can remove this line becouse it not used anymore in this call stack
        return root;
    }
}

