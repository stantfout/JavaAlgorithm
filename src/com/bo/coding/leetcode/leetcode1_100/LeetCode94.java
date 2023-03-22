package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.base.TreeNode;
import com.bo.coding.consts.TypeConst;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@GoodQuestion
@Question(type = {TypeConst.RECURSION, TypeConst.STACK, TypeConst.MORRIS_TRAVERSAL})
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
