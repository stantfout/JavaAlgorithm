package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.Undone;
import com.usth.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Undone
public class LeetCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pollLast();
            res.add(temp.val);
            if (temp.right != null) {
                stack.addLast(temp.right);
            }
            if (temp.left != null) {
                stack.addLast(temp.left);
            }
        }
        return res;
    }
}
