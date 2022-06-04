package com.leetcode.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * Amazon  Bloomberg  Microsoft  Yahoo
 */
public class LinkedListCycle_141 {
      class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    // BruteForce using HashTable

    /**
     * Time O(N)
     * Space O(N)
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        if(head ==null)
            return false;

        while(head !=null){
            if(!nodeSet.add(head))
                return true;
            head = head.next;
        }
        return false;
    }

    /**
     * Using Slow Fast Pointers
     * Time O(N)
     * Space O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
     * Memory Usage: 43.2 MB, less than 94.23% of Java online submissions for Linked List Cycle.
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head, fastPointer = head;
        while(fastPointer !=null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer)
                return true;
        }
        return false;
    }
}
