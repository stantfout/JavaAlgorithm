package com.usth.leetcode.leetcode1_100;

import com.usth.base.ListNode;

public class LeetCode_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode now = new ListNode(-1);
        ListNode res = now;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                now.next = l2;
                l2 = l2.next;
            } else {
                now.next = l1;
                l1 = l1.next;
            }
            now = now.next;
        }
        now.next = l1 == null ? l2 : l1;
        return res.next;
    }
}
