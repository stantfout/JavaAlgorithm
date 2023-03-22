package com.bo.coding.utils;

import com.bo.coding.base.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ListNodeUtils {

    /**
     * 根据字符串构建链表
     * @param listNodeStr 链表节点字符串，以 ',' 分割
     * @return 返回链表头节点，如果字符串为空，则认为链表为空，返回 null
     */
    public static ListNode buildListNodeByString(String listNodeStr) {
        if (listNodeStr == null || listNodeStr.length() == 0) {
            return null;
        }
        String[] nodes = listNodeStr.split(",");
        ListNode now = null;
        ListNode res = null;
        for (String node : nodes) {
            if (now == null) {
                now = new ListNode(Integer.parseInt(node), null);
                res = now;
            } else {
                now.next = new ListNode(Integer.parseInt(node), null);
                now = now.next;
            }
        }

        return res;
    }

    /**
     * 打印链表
     * @param node 链表头节点
     */
    public static void printListNode(ListNode node) {
        List<Integer> list = new ArrayList<>();

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        System.out.println(list);
    }
}
