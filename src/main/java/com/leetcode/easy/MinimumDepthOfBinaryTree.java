package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.*;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinimumDepthOfBinaryTree {

    /**
     * Runtime: 1 ms, faster than 97.52% of Java online submissions for Minimum Depth of Binary Tree.
     * Memory Usage: 86.7 MB, less than 78.06% of Java online submissions for Minimum Depth of Binary Tree.
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        int minimumDepth = 0;
        if(root == null)
            return minimumDepth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            minimumDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
                if (isLeaf(currentNode))
                    return minimumDepth;

            }
        }
        return minimumDepth;
    }
    private static boolean isLeaf(TreeNode node) {
        return node.right == null && node.left == null;
    }
}
