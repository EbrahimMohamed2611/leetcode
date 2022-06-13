package com.leetcode.easy;

public class MergeTwoSortedLists_21 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     Memory Usage: 41.8 MB, less than 88.35% of Java online submissions for Merge Two Sorted Lists.
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode root;
        if(list1.val > list2.val){
            root = list2;
            list2 = list2.next;
        }else{
            root = list1;
            list1 = list1.next;
        }
        ListNode tail = root;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tail.next = list2;
                list2 = list2.next;
            } else {
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;
        }

        if (list1 == null)
            tail.next = list2;
        if (list2 == null)
            tail.next = list1;

        return root;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        ListNode root = new ListNode(0);
        ListNode tail = root;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tail.next = list2;
                list2 = list2.next;
            } else {
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;
        }

        if (list1 == null)
            tail.next = list2;
        if (list2 == null)
            tail.next = list1;

        return root.next;
    }

    /**
     * Recursion
     * Time O(N)
     * Space O(N) call stack
     */
    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }
    public static void main(String[] args) {

        /**
         * Input: list1 = [1,2,4], list2 = [1,3,4]
         * Output: [1,1,2,3,4,4]
         */
        ListNode four = new ListNode(4);
        ListNode two = new ListNode(2, four);
        ListNode one = new ListNode(1, two);
        ListNode four2 = new ListNode(4);
        ListNode three = new ListNode(3, four2);
        ListNode one2 = new ListNode(1, three);

        ListNode listNode = mergeTwoLists(one, one2);
        while (listNode != null){
        System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
