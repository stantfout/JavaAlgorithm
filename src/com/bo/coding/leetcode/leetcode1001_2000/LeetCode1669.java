package com.bo.coding.leetcode.leetcode1001_2000;

import com.bo.coding.consts.TypeConst;
import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.base.ListNode;

@GoodQuestion
@Question(type = TypeConst.DATA_STRUCTURE)
public class LeetCode1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode now = new ListNode();
        now.next = list1;
        int index = -1;
        ListNode resTemp = now;
        while (now != null) {
            if (index == a - 1) {
                ListNode temp = now;
                now = now.next;
                temp.next = list2;
            } else if (index == b) {
                while (list2.next != null) {
                    list2 = list2.next;
                }
                list2.next = now.next;
                now.next = null;
                break;
            } else {
                now = now.next;
            }
            index++;
        }
        ListNode res = resTemp.next;
        resTemp = null;
        return res;
    }
}
