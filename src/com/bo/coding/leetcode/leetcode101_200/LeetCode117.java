package com.bo.coding.leetcode.leetcode101_200;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.base.Node;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.RECURSION}, status = StatusEnum.NOT_UNDERSTAND)
public class LeetCode117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node next = null;
        Node temp = root.next;
        while (temp != null) {
            if (temp.left != null || temp.right != null) {
                next = temp.left == null ? temp.right : temp.left;
                break;
            }
            temp = temp.next;
        }
        if (root.right != null) {
            root.right.next = next;
        }
        if (root.left != null) {
            root.left.next = root.right == null ? next : root.right;
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
}
