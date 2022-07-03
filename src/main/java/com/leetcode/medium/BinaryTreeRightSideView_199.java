package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

import java.util.*;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeRightSideView_199 {

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
