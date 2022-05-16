package com.leetcode.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST_938 {
    /**
     * Using DF
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Range Sum of BST.
     * Memory Usage: 49.6 MB, less than 97.37% of Java online submissions for Range Sum of BST.
     */

    public static int rangeSumBST(TreeNode root, int low, int high) {
        int sum =0;
        if(root == null)
            return 0;
        if(root.val >= low && root.val <= high)
            sum = root.val;
        if(low < root.val)
            sum += rangeSumBST(root.left, low, high);
        if(high > root.val)
            sum += rangeSumBST(root.right, low, high);

        return sum;
    }



    /**
     *Runtime: 0 ms, faster than 100.00% of Java online submissions for Range Sum of BST.
     * Memory Usage: 65.4 MB, less than 60.99% of Java online submissions for Range Sum of BST.
     */
    private static int sum =0; // but it is not thread safe
    public static int rangeSumBST2(TreeNode root, int low, int high) {
        if(root == null) return 0;
        if(root.val >= low && root.val <= high)
            sum+=root.val;
        if(low < root.val)
            rangeSumBST2(root.left, low, high);
        if(high > root.val)
            rangeSumBST2(root.right, low, high);

        return sum;
    }





    /**
     * Runtime: 11 ms, faster than 6.26% of Java online submissions for Range Sum of BST.
     * Memory Usage: 72.7 MB, less than 5.08% of Java online submissions for Range Sum of BST.
     * @param root
     * @param low
     * @param high
     * @return
     */
    public static int rangeSumBST3(TreeNode root, int low, int high) {
        List<Integer> list = new ArrayList<>();
        int sum =0;
        storeValuesInOrder(root, list);
        for(int number : list){
            if(number >= low && number <= high)
                sum+=number;
        }
        return sum;
    }
    private static void storeValuesInOrder(TreeNode root, List<Integer> values){
        if(root == null)
            return;
        storeValuesInOrder(root.left, values);
        values.add(root.val);
        storeValuesInOrder(root.right, values);
    }

    public static void main(String[] args) {

    }

}



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
