package com.leetcode.hard;

import com.leetcode.classes.ListNode;

public class ReverseNodesInkGroup {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Nodes in k-Group.
     * Memory Usage: 42.2 MB, less than 85.06% of Java online submissions for Reverse Nodes in k-Group.
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseFirstKElements(ListNode head, int k) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode node = current;
            ListNode firstElementOFSubList = current;
            ListNode lastNodeOfPreviousPart = prev;
            ListNode next = null;
            if (IsStillKNodes(node, k) < k)
                break;
            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            if (lastNodeOfPreviousPart == null)
                head = prev;
            else
                lastNodeOfPreviousPart.next = prev;

            firstElementOFSubList.next = current;

            prev = firstElementOFSubList;
        }
        return head;
    }

    private static int IsStillKNodes(ListNode node, int k) {
        int i = 0;
        for (; i < k && node != null; i++) {
            node = node.next;
        }
        return i;
    }


    /**
     * Runtime: 2 ms, faster than 11.79% of Java online submissions for Reverse Nodes in k-Group.
     * Memory Usage: 41.9 MB, less than 92.57% of Java online submissions for Reverse Nodes in k-Group.
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode firstElementOFSubList = current;
            ListNode lastNodeOfPreviousPart = prev;
            ListNode next = null;
            int i;
            for (i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }


            if (lastNodeOfPreviousPart == null)
                head = prev;
            else
                lastNodeOfPreviousPart.next = prev;

            firstElementOFSubList.next = current;

            prev = firstElementOFSubList;

            if (i != k) {
                ListNode lastNodeOfLastList = lastNodeOfPreviousPart;
                prev = lastNodeOfPreviousPart;
                current = lastNodeOfPreviousPart.next;
                ListNode temp = current;
                System.out.println(prev.val);
                System.out.println(current.val);
                for (int j = i; current != null && j >= 0; j--) {
                    next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                }
                lastNodeOfLastList.next = prev;
                temp.next = null;
                return head;
            }

        }
        return head;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1, null);
        head.next = new ListNode(2, null);
        head.next.next = new ListNode(3, null);
        head.next.next.next = new ListNode(4, null);
        head.next.next.next.next = new ListNode(5, null);
        head.next.next.next.next.next = new ListNode(6, null);
        head.next.next.next.next.next.next = new ListNode(7, null);
        head.next.next.next.next.next.next.next = new ListNode(8, null);
        System.out.println("Before Reversing");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println("\nAfter Reversing");
        ListNode current2 = reverseFirstKElements(head, 3);
        while (current2 != null) {
            System.out.print(current2.val + " -> ");
            current2 = current2.next;
        }
        System.out.print("null");
    }
}
