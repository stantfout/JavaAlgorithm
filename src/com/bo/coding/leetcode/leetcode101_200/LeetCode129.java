package com.bo.coding.leetcode.leetcode101_200;

import com.bo.coding.annotation.Question;
import com.bo.coding.base.TreeNode;

@Question
public class LeetCode129 {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        if (root != null) {
            solve(root,root.val);
        }
        return sum;
    }

    private void solve(TreeNode root, int val) {
        if (root.left == null && root.right == null) {
            sum += val;
            return;
        }
        if (root.left != null) {
            solve(root.left, val * 10 + root.left.val);
        }
        if (root.right != null) {
            solve(root.right, val * 10 + root.right.val);
        }
    }
}
