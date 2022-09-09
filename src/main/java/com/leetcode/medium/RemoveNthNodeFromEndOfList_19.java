package com.leetcode.medium;

import com.leetcode.classes.ListNode;

public class RemoveNthNodeFromEndOfList_19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        for (int i = 0; i < n; i++) {
            fastPointer = fastPointer.next;
        }
        if (fastPointer == null) return head.next;
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        slowPointer.next = slowPointer.next.next;
        return head;
    }

    /*
    Runtime: 1 ms, faster than 72.23% of Java online submissions for Remove Nth Node From End of List.
    Memory Usage: 41.4 MB, less than 84.51% of Java online submissions for Remove Nth Node From End of List.
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fastPointer = dummyNode;
        ListNode slowPointer = dummyNode;
        for (int i = 0; i <= n; i++) {
            fastPointer = fastPointer.next;
        }

        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        slowPointer.next = slowPointer.next.next;
        return dummyNode.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(1);
//        listNode.next.next.next.next = new ListNode(20);
        ListNode listNode1 = removeNthFromEnd(listNode, 1);
//        ListNode listNode1 = removeNthFromEnd2(listNode, 2);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
