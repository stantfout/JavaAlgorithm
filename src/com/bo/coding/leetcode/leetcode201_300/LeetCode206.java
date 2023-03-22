package com.bo.coding.leetcode.leetcode201_300;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.base.ListNode;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.DATA_STRUCTURE}, status = StatusEnum.FINAL_END)
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
