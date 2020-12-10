package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.NotUnderstand;
import com.usth.annotation.Undone;
import com.usth.base.Node;

@NotUnderstand
@GoodQuestion("递归/技巧")
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
