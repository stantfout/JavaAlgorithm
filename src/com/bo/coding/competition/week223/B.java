package com.bo.coding.competition.week223;

import com.bo.coding.base.ListNode;

public class B {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = null;
        ListNode last = head;
        ListNode res = head;
        while (head != null) {
            if (k > 0) {
                first = (first == null ? res : first.next);
                k--;
            } else {
                last = last.next;
            }
            head = head.next;
        }
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
        return res;
    }
}
