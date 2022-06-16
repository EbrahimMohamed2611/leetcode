package com.leetcode.easy;

import com.leetcode.classes.ListNode;

import java.util.*;

public class PalindromeLinkedList_234 {

    /**
     * Time O(n+n)
     * Space O(N)
     * Runtime: 21 ms, faster than 26.23% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 107.9 MB, less than 16.57% of Java online submissions for Palindrome Linked List.
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int left = 0, right = list.size()-1;
        while(right>left){
            if(!Objects.equals(list.get(left), list.get(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * Runtime: 5 ms, faster than 86.79% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 97.5 MB, less than 52.06% of Java online submissions for Palindrome Linked List.
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; fast = fast.next.next;
        }
        ListNode secondHalfHead = slow;
        ListNode firstHalfHead = head;
        ListNode secondHalfEnd = reverse(slow);
        while(secondHalfEnd != null && head != null){
            if(secondHalfEnd.val != head.val)
                return false;
            secondHalfEnd = secondHalfEnd.next;
            head = head.next;
        }

        return true;

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
