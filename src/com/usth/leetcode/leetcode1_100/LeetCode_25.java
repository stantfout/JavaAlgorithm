package com.usth.leetcode.leetcode1_100;

import com.usth.base.ListNode;

public class LeetCode_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //特判
        if (head == null) {
            return null;
        }
        //pre用于完成对反转后链表的连接，默认先指向head，考虑整个链表都不反转的情况
        ListNode pre = new ListNode(-1);
        pre.next = head;
        //res用于最后返回
        ListNode res = pre;
        ListNode end = head;
        while (true) {
            ListNode start = end;
            //开始找k个节点后的尾节点
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }
            //剩余链表长度小于k时退出循环
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            //pre和下个链表的头节点连接
            pre.next = reverse(start, end);
            //pre移动到当前pre链表的尾节点
            pre = start;
            //end等于下一组链表的start，继续反转
            end = next;
        }
        return res.next;
    }
    //这里传入要反转的链表的头和尾，反转操作通过迭代实现，不是很难...最后返回反转后链表的头节点。
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode head = start;
        while (head != end) {
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
