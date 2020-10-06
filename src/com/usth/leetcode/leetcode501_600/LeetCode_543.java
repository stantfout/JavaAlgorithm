package com.usth.leetcode.leetcode501_600;

import com.usth.base.TreeNode;

public class LeetCode_543 {
    private int count = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDepth(root);
        return count - 1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        count = Math.max(count,left + right + 1);
        return Math.max(left,right) + 1;
    }
}
