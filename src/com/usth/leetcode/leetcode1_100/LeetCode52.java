package com.usth.leetcode.leetcode1_100;

import com.usth.annotation.Undone;

import java.util.Arrays;

@Undone
public class LeetCode52 {
    int res = 0;
    public int totalNQueens(int n) {
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        dfs(0,vis);
        return res;
    }

    private void dfs(int index, int[] vis) {
        int n = vis.length;
        if (n == index) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (judge(vis,i, index)) {
                vis[index] = i;
                dfs(index + 1, vis);
                vis[index] = -1;
            }
        }
    }

    private boolean judge(int[] vis, int val, int index) {
        for (int i = 0; i < index; i++) {
            if (vis[i] == val ||
                    (vis[i] + i == val + index) ||
                    (vis[i] - i == val - index) ) {
                return false;
            }
        }
        return true;
    }
}
