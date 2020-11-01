package com.usth.leetcode.leetcode201_300;

import com.usth.annotation.FinalEnd;
import com.usth.base.ListNode;

@FinalEnd
public class LeetCode206 {
    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    /* 递归
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
     */
}
