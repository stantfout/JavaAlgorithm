package com.usth.leetcode.leetcode501_600;

import com.usth.annotation.Undone;
import com.usth.base.TreeNode;

@Undone
public class LeetCode530 {
    int min;
    int pre;

    public int getMinimumDifference(TreeNode root) {
        pre = -1;
        min = Integer.MAX_VALUE;
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != -1) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}
