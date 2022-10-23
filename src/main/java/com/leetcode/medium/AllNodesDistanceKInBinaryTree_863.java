package com.leetcode.medium;

import com.leetcode.classes.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree_863 {
    class Pair{
        int distance;
        TreeNode node;
        public Pair(int distance,TreeNode node ){
            this.distance = distance;
            this.node =node;
        }
    }
    /*
    Runtime: 13 ms, faster than 84.24% of Java online submissions for All Nodes Distance K in Binary Tree.
Memory Usage: 42.1 MB, less than 93.97% of Java online submissions for All Nodes Distance K in Binary Tree.
    */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // (1) build graph with adjacency List
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.remove();

            if(!graph.containsKey(current))
                graph.put(current, new ArrayList<>());

            if(current.left != null){
                queue.add(current.left);
                graph.get(current).add(current.left);
                if(!graph.containsKey(current.left))
                    graph.put(current.left, new ArrayList<>());
                graph.get(current.left).add(current);
            }

            if(current.right != null){
                queue.add(current.right);
                graph.get(current).add(current.right);
                if(!graph.containsKey(current.right))
                    graph.put(current.right, new ArrayList<>());
                graph.get(current.right).add(current);
            }
        }

        // Second we need to traverse from target to k distance
        Set<TreeNode> visited = new HashSet<>();
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(0,target));
        visited.add(target);
        List<Integer> nodes = new ArrayList<>();
        while(!qu.isEmpty()){
            Pair current = qu.remove();
            if(current.distance == k) // we don't need to go next we need unit this distance only
                nodes.add(current.node.val);
            else{
                for(TreeNode child: graph.get(current.node))
                    if(!visited.contains(child)){
                        visited.add(child);
                        qu.add( new Pair(current.distance+1,child));
                    }
            }
        }
        return nodes;
    }
}
