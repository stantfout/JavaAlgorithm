package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.NotUnderstand;
import com.usth.annotation.Undone;
import com.usth.base.Node;

@NotUnderstand
@GoodQuestion("递归/技巧")
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
