package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.Question;
import com.bo.coding.base.ListNode;

@Question
public class LeetCode24 {
    /* 递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = head.next;
        ListNode nextHead = res.next;
        res.next = head;
        head.next = swapPairs(nextHead);
        return res;
    }
    */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = head.next;
        ListNode l1 = head;
        while (l1 != null && l1.next != null) {
            ListNode l2 = l1.next;
            ListNode l3 = l2.next;
            l2.next = l1;
            if (l3 == null) {
                l1.next = null;
            } else if (l3.next == null) {
                l1.next = l3;
            } else {
                l1.next = l3.next;
            }
            l1 = l3;
        }
        return res;
    }
}
