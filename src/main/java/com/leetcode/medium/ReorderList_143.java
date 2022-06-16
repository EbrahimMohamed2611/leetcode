package com.leetcode.medium;

import com.leetcode.classes.ListNode;

public class ReorderList_143 {

    /**
     * Time O(N)
     * Space O(1)
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reorder List.
     * Memory Usage: 53.9 MB, less than 52.83% of Java online submissions for Reorder List.
     */
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; fast = fast.next.next;
        }
        ListNode secondHalfStart = reverse(slow);
        ListNode firstHalf = head;
        while(secondHalfStart != null && firstHalf != null){
            ListNode next = firstHalf.next;
            firstHalf.next = secondHalfStart;
            firstHalf = next;

            ListNode prev = secondHalfStart.next;
            secondHalfStart.next = firstHalf;
            secondHalfStart = prev;
        }
        if(firstHalf != null)
            firstHalf.next = null;

    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head; head = next;
        }
        return prev;
    }
}
