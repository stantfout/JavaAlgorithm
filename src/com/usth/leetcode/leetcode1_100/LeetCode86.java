package com.usth.leetcode.leetcode1_100;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;
import com.usth.base.ListNode;

@Undone
@GoodQuestion("链表基础")
public class LeetCode86 {

    public ListNode partition(ListNode head, int x) {
        ListNode lowTail = new ListNode();ListNode lowHead = lowTail;
        ListNode highTail = new ListNode();ListNode highHead = highTail;
        ListNode next = head;
        while (next != null) {
            if (next.val < x) {
                lowTail.next = next;
                lowTail = next;
            } else {
                highTail.next = next;
                highTail = next;
            }
            head = next;
            next = next.next;
            head.next = null;
        }
        lowTail.next = highHead.next;
        return lowHead.next;
    }
}
