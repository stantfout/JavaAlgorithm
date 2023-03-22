package com.bo.coding.leetcode.leetcode101_200;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.base.TreeNode;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.RECURSION})
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
