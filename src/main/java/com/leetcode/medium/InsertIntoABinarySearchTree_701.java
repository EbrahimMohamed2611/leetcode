package com.leetcode.medium;

import com.leetcode.classes.TreeNode;
 // https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class InsertIntoABinarySearchTree_701 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
     * Memory Usage: 53.9 MB, less than 70.50% of Java online submissions for Insert into a Binary Search Tree.
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return recursiveInsert(root, val);
    }
    private TreeNode recursiveInsert(TreeNode currentNode, int data) {
        if (currentNode == null)
            return new TreeNode(data);

        if (data > currentNode.val)
            currentNode.right = recursiveInsert(currentNode.right, data);
        else
            currentNode.left = recursiveInsert(currentNode.left, data);

        return currentNode;
    }
}
