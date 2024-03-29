package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.Question;
import com.bo.coding.base.ListNode;

@Question
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0,head);
        ListNode root = temp;
        ListNode quick = head;
        while (n-- != 0) {
            quick = quick.next;
        }
        while (quick != null) {
            quick = quick.next;
            root = root.next;
        }
        ListNode del = root.next;
        root.next = del.next;
        del.next = null;
        return temp.next;
    }
}
