package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class BinaryTreeLevelOrderTraversal_2_107 {

    /**
     * Runtime: 1 ms, faster than 98.02% of Java online submissions for Binary Tree Level Order Traversal II.
     * Memory Usage: 44.4 MB, less than 7.46% of Java online submissions for Binary Tree Level Order Traversal II.
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> nodes = new LinkedList<>();
        if (root == null) return nodes;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> nodesLevel = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                nodesLevel.add(currentNode.val);
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
            nodes.add(0, nodesLevel);
        }
        return nodes;
    }
}
