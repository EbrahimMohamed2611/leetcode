package com.leetcode.easy;

public class ConvertBinaryNumberInALinkedListToInteger_1290 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int getDecimalValue(ListNode head) {
        if (head.next == null)
            return head.val;
        long result = head.val;
        head = head.next;
        while (head != null) {
            if (head.val == 1) {
                result = (result * 10) + 1;
            } else {
                result = (result * 10);
            }
            head = head.next;
        }
        System.out.println(result);
        long decimal = 0;
        long counter = 0;
        while (result != 0) {
            decimal = (long) (decimal + Math.pow(2, counter++) * (result % 10));
            result = result / 10;
        }
        return(int) decimal;
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
