package com.leetcode.easy;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList_206 {
    public static void main(String[] args) {

    }


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     * Memory Usage: 42.9 MB, less than 54.95% of Java online submissions for Reverse Linked List.
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode next, prev, current;
        prev = null;
        current = head;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev =current;
            current = next;

        }
        head= prev;
        return head;
    }
}
