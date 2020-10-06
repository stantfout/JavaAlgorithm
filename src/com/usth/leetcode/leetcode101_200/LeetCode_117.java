package com.usth.leetcode.leetcode101_200;

import com.usth.base.Node;

public class LeetCode_117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node pre = null;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            pre = root.right;
        } else if (root.left != null || root.right != null) {
            pre = root.left == null ? root.right : root.left;
        }
        Node next = null;
        Node temp = root;
        while (temp.next != null) {
            if (temp.next.left != null) {
                next = temp.next.left;
                break;
            }
            if (temp.next.right != null) {
                next = temp.next.right;
                break;
            }
            temp = temp.next;
        }
        if (pre != null) {
            pre.next = next;
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
}
