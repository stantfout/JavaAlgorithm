package com.bo.coding.leetcode.leetcode901_1000;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.DISJOINT_SET_DATA_STRUCTURE}, status = StatusEnum.FINAL_END)
public class LeetCode990 {
    public boolean equationsPossible(String[] equations) {
        int[] pre = new int[26];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = i;
        }
        for (String equation : equations) {
            char x = equation.charAt(0);
            char y = equation.charAt(3);
            if (equation.charAt(1) == '=') {
                union(pre, x - 'a', y - 'a');
            }
        }
        for (String equation : equations) {
            char x = equation.charAt(0);
            char y = equation.charAt(3);
            if (equation.charAt(1) == '!') {
                if (find(pre, x - 'a') == find(pre, y - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    private int find(int[] pre, int x) {
        if (pre[x] == x) {
            return pre[x];
        }
        pre[x] = find(pre, pre[x]);
        return pre[x];
    }

    private void union(int[] pre, int x, int y) {
        int fx = find(pre, x);
        int fy = find(pre, y);
        if (fx != fy) {
            pre[fx] = fy;
        }
    }
}
