package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.Undone;
import com.usth.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Undone
public class LeetCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addLast(root);
                root = root.left;
            }
            root = stack.peekLast();
            if (root.right == null || root.right == pre) {
                list.add(root.val);
                stack.pollLast();
                pre = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return list;
    }
}
