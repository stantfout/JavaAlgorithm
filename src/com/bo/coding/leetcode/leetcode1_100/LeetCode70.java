package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@Question(status = StatusEnum.FINAL_END, type = {TypeConst.DYNAMIC_PROGRAMMING})
public class LeetCode70 {
    public int climbStairs(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3;
        for (int i = 2; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }
}
