package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {


    /*
    Runtime: 2 ms, faster than 99.13% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
Memory Usage: 41.9 MB, less than 93.70% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    */
    Map<Integer, Integer> valueWithIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i =0; i<inorder.length ; i++)
            valueWithIndexMap.put(inorder[i],i);

        return buildTree(0, preorder.length-1, preorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int preStart, int preEnd, int[] preorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd )
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndexInInorder = valueWithIndexMap.get(root.val);
        int numberOfElementLeftOnRootInInorder = rootIndexInInorder - inStart;

        root.left = buildTree(preStart+1, preStart + numberOfElementLeftOnRootInInorder, preorder,
                inStart,rootIndexInInorder-1);

        root.right = buildTree(preStart +numberOfElementLeftOnRootInInorder+1, preEnd,preorder,
                rootIndexInInorder+1, inEnd);

        return root;
    }
}