package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

import java.util.*;

public class BinarySearchTreeIterator_173 {
    /*
    Runtime: 15 ms, faster than 97.15% of Java online submissions for Binary Search Tree Iterator.
    Memory Usage: 46 MB, less than 97.27% of Java online submissions for Binary Search Tree Iterator.*/
    Stack<TreeNode> stack = new Stack<>();
    public BinarySearchTreeIterator_173(TreeNode root) {
        pushToStack(root);
    }

    public int next() {
        TreeNode root = stack.pop();
        pushToStack(root.right);
        return root.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushToStack(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
}
