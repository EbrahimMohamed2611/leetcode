package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRootToLeafNumbers_129 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
     * Memory Usage: 42.7 MB, less than 6.01% of Java online submissions for Sum Root to Leaf Numbers.
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {

        return sunPathNumbers(root, 0); // 0 initial value for sum

    }

    private int sunPathNumbers(TreeNode root, int sum){
        if(root == null) return 0;
        sum = sum *10 + root.val;
        if(isLeaf(root))
            return sum;
        return sunPathNumbers(root.left, sum) + sunPathNumbers(root.right, sum);
    }

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}
