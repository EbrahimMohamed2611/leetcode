package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

import java.util.*;

//https://leetcode.com/problems/find-largest-value-in-each-tree-row/
public class FindLargestValueInEachTreeRow_515 {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Find Largest Value in Each Tree Row.
     * Memory Usage: 42.4 MB, less than 92.66% of Java online submissions for Find Largest Value in Each Tree Row.
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValuesInEachLevel = new ArrayList<>();
        if(root == null)
            return largestValuesInEachLevel;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max;
        while (!queue.isEmpty()){
            max = Integer.MIN_VALUE;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(node.val >= max)
                    max = node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            largestValuesInEachLevel.add(max);
        }

        return largestValuesInEachLevel;
    }
}
