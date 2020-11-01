package com.usth.others;

import com.usth.base.TreeNode;

public class Coding_04_12 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return solve(root, sum) + pathSum(root.left ,sum) + pathSum(root.right, sum);
    }

    private int solve(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (sum - root.val == 0) {
            return 1;
        }
        return solve(root.left, sum - root.val) + solve(root.right, sum - root.val);
    }
}
