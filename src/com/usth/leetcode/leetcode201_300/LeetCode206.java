package com.usth.leetcode.leetcode201_300;

import com.usth.annotation.FinalEnd;
import com.usth.base.ListNode;

@FinalEnd
public class LeetCode206 {
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
