package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

import java.util.*;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideView_199 {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Right Side View.
    Memory Usage: 41 MB, less than 91.45% of Java online submissions for Binary Tree Right Side View.
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> rightViewNodes = new ArrayList<>();
        if (root == null) return rightViewNodes;
        rightSideView(root,0,rightViewNodes);
        return rightViewNodes;
    }
    private void rightSideView(TreeNode root, int level,List<Integer> rightViewNodes ){
        // Will use Pre Order Reversed
        if(root == null) return;
        if(rightViewNodes.size() == level)
            rightViewNodes.add(root.val);

        rightSideView(root.right, level+1, rightViewNodes);
        rightSideView(root.left, level+1, rightViewNodes);
    }
    /**
     * Runtime: 1 ms, faster than 94.71% of Java online submissions for Binary Tree Right Side View.
     * Memory Usage: 42.9 MB, less than 41.76% of Java online submissions for Binary Tree Right Side View.
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewNodes = new ArrayList<>();
        if(root == null) return rightViewNodes;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(i == levelSize-1)
                    rightViewNodes.add(node.val);

                if(node.left != null)
                    queue.add(node.left);

                if(node.right != null)
                    queue.add(node.right);
            }
        }
        return rightViewNodes;
    }
}
