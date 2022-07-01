package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

// https://leetcode.com/problems/delete-node-in-a-bst/
public class DeleteNodeInABST_450 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
     * Memory Usage: 43 MB, less than 83.63% of Java online submissions for Delete Node in a BST.
     * @param current
     * @param data
     * @return
     */
    public TreeNode deleteNode(TreeNode current, int data) {
        if (current == null) {
            return null;
        }
        // first we need to get the node
        if (data > current.val) {
            current.right = deleteNode(current.right, data);
        } else if (data < current.val) {
            current.left = deleteNode(current.left, data);
        } else {

            if (isLeaf(current)) {
                return null;
            } else if (current.left != null && current.right == null) {
                return current.left;
            } else if (current.right != null && current.left == null) {
                return current.right;
            } else {
                TreeNode smallestValueInRight = min(current.right);
                current.val = smallestValueInRight.val;
                current.right = deleteNode(current.right, smallestValueInRight.val);
            }
        }
        return current;
    }
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private TreeNode min(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
