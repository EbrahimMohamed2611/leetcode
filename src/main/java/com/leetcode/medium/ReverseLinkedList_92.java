package com.leetcode.medium;

import com.leetcode.classes.ListNode;

public class ReverseLinkedList_92 {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
     * Memory Usage: 40 MB, less than 91.07% of Java online submissions for Reverse Linked List II.
     */
    public ListNode reverseBetween(ListNode head, int start, int end) {
        // we need to store the node at position start and also the prev
        ListNode current = head;
        ListNode prev = null;

        for (int i = 0; current != null && i < start - 1; i++) {
            prev = current;
            current = current.next;
        }
        ListNode startOfSubList = current;
        ListNode prevOfSubList = prev;

        ListNode next = null;
        for (int i = 0; current != null && i <= end - start; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (prevOfSubList == null)
            head = prev;
        else
            prevOfSubList.next = prev;

        startOfSubList.next = current;
        return head;
    }
}
