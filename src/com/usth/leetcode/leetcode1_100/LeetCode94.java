package com.usth.leetcode.leetcode1_100;

import com.usth.annotation.Undone;
import com.usth.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Undone
public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
            TreeNode temp = stack.pollLast();
            res.add(temp.val);
            root = temp.right;
        }
        return res;
    }
}
