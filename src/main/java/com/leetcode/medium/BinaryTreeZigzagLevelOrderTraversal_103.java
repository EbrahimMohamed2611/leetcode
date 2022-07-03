package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

import java.util.*;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal_103 {

    enum Direction{
        LEFT, RIGHT
    }
    /**
     * Runtime: 1 ms, faster than 95.87% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     * Memory Usage: 41.8 MB, less than 83.02% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> values = new LinkedList<>();
        if(root == null)
            return values;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Direction currentDirection = Direction.LEFT;
        while (!queue.isEmpty()){
            List<Integer> linkedList = new LinkedList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(currentDirection == Direction.LEFT)
                    linkedList.add(node.val);
                else
                    linkedList.add(0,node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            if(currentDirection == Direction.LEFT)
                currentDirection = Direction.RIGHT;
            else
                currentDirection = Direction.LEFT;

            values.add(linkedList);
        }
        return values;

    }
}
