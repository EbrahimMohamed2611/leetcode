package com.leetcode.medium;

import com.leetcode.classes.ListNode;
// Amazon Apple Bloomberg Microsoft Adobe Facebook Google Uber IBM Oracle SAP
public class AddTwoNumbers_2 {

    /*
    Runtime: 2 ms, faster than 99.44% of Java online submissions for Add Two Numbers.
    Memory Usage: 42.7 MB, less than 87.15% of Java online submissions for Add Two Numbers.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyNode= new ListNode();
        ListNode head = dummyNode;
        ListNode prev = null;
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0 ){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            int currentValue = sum % 10;
            carry = sum / 10;
            head.next = new ListNode(currentValue);
            head = head.next;
        }


        return dummyNode.next;
    }
}
