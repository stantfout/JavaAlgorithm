package com.usth.leetcode.leetcode1_100;

import com.usth.base.ListNode;

public class LeetCode_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int val = flag;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            flag = val / 10;
            pre.next = new ListNode(val % 10);
            pre = pre.next;
        }
        pre.next = flag == 0 ? null : new ListNode(flag);
        return head.next;
    }
}
