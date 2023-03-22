package com.bo.coding.leetcode.leetcode101_200;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.base.Node;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.RECURSION}, status = StatusEnum.NOT_UNDERSTAND)
public class LeetCode116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root;
        while (left.left != null) {
            Node temp = left;
            while (temp != null) {
                temp.left.next = temp.right;
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            left = left.left;
        }
        return root;
    }
}
