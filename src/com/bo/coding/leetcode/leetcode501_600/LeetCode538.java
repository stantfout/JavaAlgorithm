package com.bo.coding.leetcode.leetcode501_600;

import com.bo.coding.annotation.Question;
import com.bo.coding.base.TreeNode;

@Question
public class LeetCode538 {
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
