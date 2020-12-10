package com.usth.leetcode.leetcode201_300;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;
import com.usth.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@Undone
@GoodQuestion("二叉搜索树特性")
public class LeetCode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;
        while (temp != null) {
            if (temp.val > p.val && temp.val > q.val) {
                temp = temp.left;
            } else if (temp.val < p.val && temp.val < q.val) {
                temp = temp.right;
            } else {
                break;
            }
        }
        return temp;
    }
}
