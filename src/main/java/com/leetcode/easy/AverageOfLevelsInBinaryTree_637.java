package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.*;

//https://leetcode.com/problems/average-of-levels-in-binary-tree/
public class AverageOfLevelsInBinaryTree_637 {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Average of Levels in Binary Tree.
     * Memory Usage: 43.5 MB, less than 96.59% of Java online submissions for Average of Levels in Binary Tree.
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> average = new ArrayList<>();
        if (root == null) return average;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
            average.add(sum/levelSize);
        }
        return average;
    }

}
