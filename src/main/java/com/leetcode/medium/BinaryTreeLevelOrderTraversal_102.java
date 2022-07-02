package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

import java.util.*;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class BinaryTreeLevelOrderTraversal_102 {

    /**
     * Runtime: 1 ms, faster than 92.07% of Java online submissions for Binary Tree Level Order Traversal.
     * Memory Usage: 43 MB, less than 77.28% of Java online submissions for Binary Tree Level Order Traversal.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return allNodes;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> nodesPerLevel = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                nodesPerLevel.add(currentNode.val);
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
            allNodes.add(nodesPerLevel);
        }
        return allNodes;
    }
}
