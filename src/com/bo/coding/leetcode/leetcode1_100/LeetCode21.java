package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;
import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.base.ListNode;

@GoodQuestion
@Question(type = TypeConst.DATA_STRUCTURE, status = StatusEnum.FINAL_END)
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode now = new ListNode(-1);
        ListNode res = now;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                now.next = l2;
                l2 = l2.next;
            } else {
                now.next = l1;
                l1 = l1.next;
            }
            now = now.next;
        }
        now.next = l1 == null ? l2 : l1;
        return res.next;
    }
}
