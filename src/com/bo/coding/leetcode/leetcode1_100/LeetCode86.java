package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.base.ListNode;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.DATA_STRUCTURE})
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
