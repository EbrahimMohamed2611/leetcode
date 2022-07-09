package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

//https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchInABinarySearchTree_700 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search Tree.
     * Memory Usage: 51.6 MB, less than 38.38% of Java online submissions for Search in a Binary Search Tree.
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val)
            return root;
        else if(val > root.val){
            return searchBST(root.right, val);
        }

        else{
            return searchBST(root.left, val);
        }

    }
}
