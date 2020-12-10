package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;
import com.usth.base.TreeNode;

@Undone
@GoodQuestion("复杂递归")
public class LeetCode124 {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int res = maxSum(root);
        return max < 0 ? max : Math.max(res,max);
    }

    private int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxSum(root.left);
        int rightMax = maxSum(root.right);
        max = Math.max(max,leftMax + rightMax + root.val);
        return Math.max(Math.max(leftMax,rightMax) + root.val,0);
    }
}
