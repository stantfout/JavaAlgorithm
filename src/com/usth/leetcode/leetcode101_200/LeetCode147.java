package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.FinalEnd;
import com.usth.annotation.GoodQuestion;
import com.usth.base.ListNode;

@FinalEnd
@GoodQuestion("链表")
public class LeetCode147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        ListNode now = tail.next;
        while (now != null) {
            if (head.val > now.val) {
                tail.next = now.next;
                now.next = head;
                head = now;
            } else if (tail.val <= now.val) {
                tail = now;
            } else {
                ListNode pre = head;
                ListNode temp = head.next;
                while (temp.val <= now.val) {
                    pre = temp;
                    temp = temp.next;
                }
                tail.next = now.next;
                now.next = temp;
                pre.next = now;
            }
            now = tail.next;
        }
        return head;
    }
}
