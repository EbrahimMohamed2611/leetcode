package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

import java.util.*;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KSmallestElementInBST_230 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a BST.
     * Memory Usage: 42.3 MB, less than 90.88% of Java online submissions for Kth Smallest Element in a BST.
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> elements = new ArrayList<>();
        inOrder(root, elements,k);
        return elements.get(k-1) ;
    }
    private void inOrder(TreeNode current,List<Integer> list, int k){
        if(current == null) return;
        if(list.size() >= k)
            return ;
        inOrder(current.left,list,k);
        list.add(current.val);
        inOrder(current.right, list,k);
    }
}
