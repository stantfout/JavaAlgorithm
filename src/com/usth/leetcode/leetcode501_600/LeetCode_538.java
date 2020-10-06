package com.usth.leetcode.leetcode501_600;

import com.usth.base.TreeNode;

public class LeetCode_538 {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val += sum;
            sum = root.val;
            convertBST(root.left);
        }
        return root;
    }
}
