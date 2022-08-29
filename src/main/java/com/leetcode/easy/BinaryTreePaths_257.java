package com.leetcode.easy;

import com.leetcode.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {

    /*
    Runtime: 12 ms, faster than 51.00% of Java online submissions for Binary Tree Paths.
    Memory Usage: 43.7 MB, less than 14.58% of Java online submissions for Binary Tree Paths.
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();

        binaryTreePaths(path, root, "");
        return path;
    }

    private static void binaryTreePaths(List<String> paths, TreeNode root, String path) {
        if (root == null) return;
        path += root.val;

        if (root.right == null && root.left == null) {
            paths.add(path);
            return;
        }
        binaryTreePaths(paths, root.left, path + "->");
        binaryTreePaths(paths, root.right, path + "->");

    }

    // using String builder
    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Paths.
    Memory Usage: 43 MB, less than 74.73% of Java online submissions for Binary Tree Paths.
     */
    public static List<String> binaryTreePaths2(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb.append(root.val));
        return res;
    }

    /*
    The time complexity for the problem should be O(n), since we are basically visiting each node in the tree.
     Yet an interviewer might ask you for further optimization when he or she saw a string concatenation.
      A string concatenation is just too costly.
     A StringBuilder can be used although a bit tricky since it is not immutable like string is.

        When using StringBuilder, We can just keep track of the length of the StringBuilder before we append anything to it before recursion and
        afterwards set the length back. Another trick is when to append the "->", since we don't need the last arrow at the end of the string, we only append it before recurse to the next level of the tree. Hope the solution helps!
     */

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Binary Tree Paths.
    Memory Usage: 42.8 MB, less than 84.35% of Java online submissions for Binary Tree Paths.
     */
    private static void helper(List<String> res, TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        if (root.left != null) {
            int currentLength = sb.length();
            helper(res, root.left, sb.append("->").append(root.left.val));
            sb.setLength(currentLength);
        }
        if (root.right != null) {
            int currentLength = sb.length();
            helper(res, root.right, sb.append("->").append(root.right.val));
            sb.setLength(currentLength);
        }

    }

    public static void main(String[] args) {
        /*
        Input: root = [1,2,3,null,5]
        Output: ["1->2->5","1->3"]
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(root));
        System.out.println(binaryTreePaths2(root));

    }
}
