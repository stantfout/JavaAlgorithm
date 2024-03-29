package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@GoodQuestion
@Question(type = {TypeConst.DFS})
public class LeetCode51 {
    public List<List<String>> solveNQueens(int n) {
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        List<List<String>> res = new ArrayList<>();
        dfs(vis,0, res);
        return res;
    }

    private void dfs(int[] vis, int index, List<List<String>> res) {
        int n = vis.length;
        if (n == index) {
            res.add(build(vis));
        }
        for (int i = 0; i < n; i++) {
            if (judge(vis,i, index)) {
                vis[index] = i;
                dfs(vis, index + 1, res);
                vis[index] = -1;
            }
        }
    }

    private List<String> build(int[] vis) {
        int n = vis.length;
        List<String> list = new ArrayList<>();
        for (int vi : vis) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j != vi) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            list.add(sb.toString());
        }
        return list;
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
