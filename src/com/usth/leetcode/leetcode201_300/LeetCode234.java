package com.usth.leetcode.leetcode201_300;

import com.usth.annotation.Undone;
import com.usth.base.ListNode;

@Undone
public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode temp = reverse(mid);
        ListNode root = temp;
        while (head != null && temp != null) {
            if (head.val != temp.val) {
                return false;
            }
            head = head.next;
            temp = temp.next;
        }
        slow.next = reverse(root);
        return true;
    }

    private ListNode reverse(ListNode root) {
        ListNode pre = null;
        while (root != null) {
            ListNode next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }

}
