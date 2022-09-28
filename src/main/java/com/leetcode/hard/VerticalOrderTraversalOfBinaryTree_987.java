package com.leetcode.hard;

import com.leetcode.classes.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree_987 {
    /*
    Runtime: 4 ms, faster than 81.21% of Java online submissions for Vertical Order Traversal of a Binary Tree.
    Memory Usage: 42.8 MB, less than 76.59% of Java online submissions for Vertical Order Traversal of a Binary Tree.
    */
    private class Tuple {
        TreeNode node;
        int vertical;
        int level;

        Tuple(TreeNode node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // root will be in level 0 and vertical 0 (0,0)
        Tuple node = new Tuple(root, 0, 0);
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            if (!map.containsKey(current.vertical))
                map.put(current.vertical, new TreeMap<>());

            if (!map.get(current.vertical).containsKey(current.level))
                map.get(current.vertical).put(current.level, new PriorityQueue<>());

            map.get(current.vertical).get(current.level).add(current.node.val);

            // here we need to push new nodes with new V and L to Queue
            // when go left we need to decrease the vertical value and increase the level value
            if (current.node.left != null)
                queue.offer(new Tuple(current.node.left, current.vertical - 1, current.level + 1));

            // when go left we need to increase the vertical value and increase the level value
            if (current.node.right != null)
                queue.offer(new Tuple(current.node.right, current.vertical + 1, current.level + 1));
        }

        //final step we need to populate the values
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (Map<Integer, PriorityQueue<Integer>> vertical : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> level : vertical.values()) {
                while (!level.isEmpty())
                    list.get(list.size()-1).add(level.remove());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        VerticalOrderTraversalOfBinaryTree_987 verticalOrderTraversalOfBinaryTree = new VerticalOrderTraversalOfBinaryTree_987();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);

        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
//        treeNode.right.right = new TreeNode(9);
        ArrayList<ArrayList<Integer>> list = verticalOrderTraversalOfBinaryTree.verticalOrderTraversal(treeNode);
        System.out.println(list);
    }
}
