package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

public class RecoverBinarySearchTree_99 {

    private TreeNode firstNode, prevNode, middleNode, lastNode;

    /*
    Time: O(N)
    Space O(1)
    Runtime: 2 ms, faster than 99.92% of Java online submissions for Recover Binary Search Tree.
    Memory Usage: 42.6 MB, less than 89.52% of Java online submissions for Recover Binary Search Tree.
     */
    public void recoverTreeUsingMorris(TreeNode root) {
        if (root == null)
            return;
        TreeNode current = root;
        TreeNode predecessor = null;

        while (current != null) {

            if (current.left == null) {
                // logic here
                if (prevNode != null && prevNode.val > current.val) {
                    if(firstNode == null){
                        firstNode = prevNode;
                        middleNode = current;
                    }
                    lastNode =current;
                }

                prevNode = current;
                current = current.right;
            } else {
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) // Second condition to avoid cycle
                    predecessor = predecessor.right;

                if (predecessor.right == null) {
                    predecessor.right = current; // create link between root and predecessor
                    current = current.left; // then go to left
                } else { // here we need to fix the links
                    predecessor.right = null;
                    // logic should be here
                    if (prevNode != null && prevNode.val > current.val) {
                        if(firstNode == null){
                            firstNode = prevNode;
                            middleNode = current;
                        }
                        lastNode =current;
                    }

                    prevNode = current;
                    current = current.right; // go right because we reach the end of all left subTree
                }
            }
        }

        if(firstNode != null && lastNode != null)
            swap(firstNode, lastNode);
        else
            swap(firstNode, middleNode);
    }

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
