package com.usth.leetcode.leetcode501_600;

import com.usth.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_501 {
    int now, cnt, max;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        now = 0; cnt = 0; max = 0;
        dfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int val) {
        if (now == val) {
            cnt++;
        } else {
            cnt = 1;
            now = val;
        }
        if (cnt == max) {
            list.add(val);
        } else if (cnt > max) {
            list.clear();
            max = cnt;
            list.add(val);
        }
    }
}
