package com.usth.leetcode.leetcode201_300;

import com.usth.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return null;
        }
        if (p.val > q.val) {
            TreeNode t = p;
            p = q;
            q = t;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.val >= p.val && temp.val <= q.val) {
                return temp;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return null;
    }
}
