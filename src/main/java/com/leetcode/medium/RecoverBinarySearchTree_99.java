package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

public class RecoverBinarySearchTree_99 {

    /*
    Runtime: 2 ms, faster than 99.92% of Java online submissions for Recover Binary Search Tree.
    Memory Usage: 48.1 MB, less than 9.83% of Java online submissions for Recover Binary Search Tree.
     */
    TreeNode first, middle, prev, last;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        recoverTreeRecursive(root);
        if(first != null && last != null)
            swap(first, last);
        else
            swap(first, middle);
    }

    private void recoverTreeRecursive(TreeNode root){
        if(root == null)
            return;

        recoverTreeRecursive(root.left);
        if(prev != null && prev.val > root.val){
            if(first == null){ // for the first mistake and also cane be only the mistake
                first = prev;
                middle = root;
            }else
                last = root; // when we see the second mistake
        }
        prev = root;

        recoverTreeRecursive(root.right);
    }


    private void swap(TreeNode first, TreeNode last){
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
}
