package com.leetcode.easy;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 */

public class RemoveLinkedListElements_203 {
    public static void main(String[] args) {

    }


//      Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    /**
     * Runtime: 1 ms, faster than 90.94% of Java online submissions for Remove Linked List Elements.
     * Memory Usage: 49.5 MB, less than 18.56% of Java online submissions for Remove Linked List Elements.
     * @param head
     * @param val
     * @return
     */

    public static ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0, head);
        ListNode prev = newHead;
        ListNode current = head;
        while(current != null){
            if(current.val == val){
                prev.next =current.next;
            }else{
                prev =current;
            }
            current = current.next;
        }
        return newHead.next;
    }
}
