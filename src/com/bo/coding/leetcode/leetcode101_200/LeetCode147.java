package com.bo.coding.leetcode.leetcode101_200;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.base.ListNode;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.DATA_STRUCTURE}, status = StatusEnum.FINAL_END)
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
