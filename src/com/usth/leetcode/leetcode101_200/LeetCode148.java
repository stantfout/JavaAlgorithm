package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.Undone;
import com.usth.base.ListNode;

@Undone
public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        ListNode root = new ListNode(0);
        ListNode temp = root;
        while (left != null && right != null) {
            if (left.val > right.val) {
                temp.next = right;
                right = right.next;
            } else {
                temp.next = left;
                left = left.next;
            }
            temp = temp.next;
        }
        temp.next = left == null ? right : left;
        return root.next;
    }
}
