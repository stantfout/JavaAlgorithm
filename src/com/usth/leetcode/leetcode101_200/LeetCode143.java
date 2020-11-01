package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.Undone;
import com.usth.base.ListNode;

@Undone
public class LeetCode143 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = getMidNode(head);
        ListNode temp = mid;
        mid = reverseList(mid.next);
        temp.next = null;
        while (head != null && mid != null) {
            ListNode hNext = head.next;
            ListNode mNext = mid.next;
            head.next = mid;
            mid.next = hNext;
            mid = mNext;
            head = hNext;
        }
    }

    private ListNode reverseList(ListNode mid) {
        ListNode pre = null;
        ListNode cur = mid;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}

