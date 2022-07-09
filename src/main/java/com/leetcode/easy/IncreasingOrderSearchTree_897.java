package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class IncreasingOrderSearchTree_897 {
    /**
     *Runtime: 0 ms, faster than 100.00% of Java online submissions for Increasing Order Search Tree.
     * Memory Usage: 41.5 MB, less than 15.95% of Java online submissions for Increasing Order Search Tree.
     * @param
     */

    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        for(int i =0; i < list.size()-1; i++){
            list.get(i).right = list.get(i+1);
            list.get(i).left = null;
        }
        list.get(list.size()-1).left = null;
        return list.get(0);
    }

    private void inOrder(TreeNode root, List<TreeNode> list){
        if(root == null)
            return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);

    }
}

