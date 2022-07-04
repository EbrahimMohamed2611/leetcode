package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

import java.util.*;

// https://leetcode.com/problems/path-sum-ii/
public class PathSum_113 {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Path Sum II.
     * Memory Usage: 42.9 MB, less than 87.84% of Java online submissions for Path Sum II.
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        allPathsRecursively(root, sum, allPaths, new ArrayList<>());
        return allPaths;
    }
    private void allPathsRecursively(TreeNode node, int sum, List<List<Integer>> pathsSum, List<Integer> path) {
        if (node == null)
            return;

        path.add(node.val);
        if (sum == node.val && isLeaf(node)) {
            pathsSum.add(new ArrayList<>(path));
        }
        allPathsRecursively(node.left, sum - node.val, pathsSum, path);
        allPathsRecursively(node.right, sum - node.val, pathsSum, path);

        path.remove(path.size()-1);
    }


    private boolean isLeaf(TreeNode node) {
        return node.right == null && node.left == null;
    }
}
