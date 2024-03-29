package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 42.8 MB, less than 69.68% of Java online submissions for Maximum Depth of Binary Tree.
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        return maximumDepthRecur(root, 0) + 1;
    }

    private static int maximumDepthRecur(TreeNode root, int depth) {
        if (root == null)
            return -1;
        if (isLeaf(root))
            return depth;
        int leftDepth = maximumDepthRecur(root.left, depth + 1);
        int rightDepth = maximumDepthRecur(root.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.right == null && node.left == null;
    }


    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 42.3 MB, less than 82.14% of Java online submissions for Maximum Depth of Binary Tree.
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    /**
     Runtime: 1 ms, faster than 24.74% of Java online submissions for Maximum Depth of Binary Tree.
     Memory Usage: 43.5 MB, less than 27.19% of Java online submissions for Maximum Depth of Binary Tree.
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        int maximumDepth = 0;
        if(root == null)
            return maximumDepth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            maximumDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
        }
        return maximumDepth;
    }



}
