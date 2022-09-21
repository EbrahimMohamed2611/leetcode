package com.leetcode.medium;


import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
    Memory Usage: 42 MB, less than 91.57% of Java online submissions for Copy List with Random Pointer.
    */
    public Node copyRandomList2(Node head) {
        Map<Node, Node> oldWithNewNodes = new HashMap<>();
        Node current = head;
        while (current != null) {
            Node cloned = oldWithNewNodes.get(current);
            if (cloned == null) {
                cloned = new Node(current.val);
                oldWithNewNodes.put(current, cloned);
            }

            if (current.next != null) {
                Node nxt = oldWithNewNodes.get(current.next);
                if (nxt == null) {
                    nxt = new Node(current.next.val);
                    oldWithNewNodes.put(current.next, nxt);
                }
                cloned.next = nxt;
            }

            if (current.random != null) {
                Node rand = oldWithNewNodes.get(current.random);
                if (rand == null) {
                    rand = new Node(current.random.val);
                    oldWithNewNodes.put(current.random, rand);
                }
                cloned.random = rand;
            }


            current = current.next;
        }
        return oldWithNewNodes.get(head) == null ? null : oldWithNewNodes.get(head);
    }


    /*
    Runtime: 1 ms, faster than 48.63% of Java online submissions for Copy List with Random Pointer.
    Memory Usage: 45.2 MB, less than 76.35% of Java online submissions for Copy List with Random Pointer.
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldWithNewNodes = new HashMap<>();
        // first copy every node with corresponding Old Node
        Node current = head;
        while (current != null) {
            oldWithNewNodes.put(current, new Node(current.val));
            current = current.next;
        }

        // second handle the next and random pointer
        current = head;
        while (current != null) {
            Node newNode = oldWithNewNodes.get(current);
            newNode.next = oldWithNewNodes.get(current.next);
            newNode.random = oldWithNewNodes.get(current.random);
            current = current.next;
        }
        return oldWithNewNodes.get(head);
    }


}
