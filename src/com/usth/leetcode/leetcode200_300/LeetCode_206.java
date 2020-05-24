package com.usth.leetcode.leetcode200_300;

import com.usth.base.ListNode;

public class LeetCode_206 {
    private ListNode res;
    public ListNode reverseList(ListNode head) {
        reverse(head);
        return res;
    }

    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            res = head;
            return head;
        }
        ListNode pre = reverse(head.next);
        head.next = null;
        pre.next = head;
        return head;
    }
}
