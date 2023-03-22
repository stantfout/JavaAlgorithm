package com.bo.coding.competition.twoweek40;

import com.bo.coding.base.ListNode;

public class B {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aNode = list1;
        ListNode bNode = list1;
        while (a > 1 || b > 0) {
            if (a > 1) {
                aNode = aNode.next;
                a--;
            }
            if (b > 0) {
                bNode = bNode.next;
                b--;
            }
        }
        ListNode next = bNode.next;
        ListNode pre = null;
        ListNode end = list2;
        while (end != null) {
            pre = end;
            end = end.next;
        }
        aNode.next = list2;
        pre.next = next;
        return list1;
    }
}
