package com.leetcode.easy;

public class ConvertBinaryNumberInALinkedListToInteger_1290 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Time O(N)
     * Space O(1)
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
     * Memory Usage: 41.8 MB, less than 35.98% of Java online submissions for Convert Binary Number in a Linked List to Integer.
     * @param head
     * @return
     */
    public static int getDecimalValue(ListNode head) {
        if (head.next == null)
            return head.val;
        int sum = head.val;
        head = head.next;
        while(head != null){
            sum  = (sum<<1) | head.val;
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(101/10);
        ListNode list = new ListNode(1);
        list.next = new ListNode(0);
        list.next.next = new ListNode(1);
        int decimalValue = getDecimalValue(list);
        System.out.println(decimalValue);
    }
}
