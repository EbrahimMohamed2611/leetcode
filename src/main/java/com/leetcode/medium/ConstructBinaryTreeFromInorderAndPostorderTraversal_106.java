package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    /*
    Runtime: 2 ms, faster than 98.43% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
    Memory Usage: 42.1 MB, less than 89.72% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
    */
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return buildTree(0, inorder.length - 1, inorder, 0, postorder.length - 1, postorder);
    }

    private TreeNode buildTree(int inStart, int inEnd, int[] inorder, int postStart, int postEnd, int[] postorder) {
        if (inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = map.get(postorder[postEnd]);
        int numsLeft = rootIndex - inStart;

        //root.left = buildTree(inStart, inStart + numsLeft -1, inorder, postStart, postStart + numsLeft -1, postorder); OR
        root.left = buildTree(inStart, rootIndex - 1, inorder, postStart, postStart + numsLeft - 1, postorder);
        root.right = buildTree(rootIndex + 1, inEnd, inorder, postStart + numsLeft, postEnd - 1, postorder);
        return root;
    }
}
