package com.bo.coding.leetcode.leetcode1001_2000;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;
@GoodQuestion
@Question(type = {TypeConst.DYNAMIC_PROGRAMMING}, status = StatusEnum.FINAL_END)
public class LeetCode1463 {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];
        dp[0][0][m - 1] = grid[0][0] + grid[0][m - 1];

        for (int i = 1; i < n; i++) {
            int len = Math.min(m,i + 1);
            for (int j1 = 0; j1 < len; j1++) {
                for (int j2 = m - 1; j2 >= m - len; j2--) {
                    int max = 0;
                    for (int k1 = -1; k1 <= 1; k1++) {
                        for (int k2 = -1; k2 <= 1; k2++) {
                            int nj1 = j1 + k1;
                            int nj2 = j2 + k2;
                            if (nj1 >= 0 && nj1 < m && nj2 >=0 && nj2 < m) {
                                max = Math.max(max, dp[i - 1][nj1][nj2]);
                            }
                        }
                    }
                    dp[i][j1][j2] = max + ((j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res,dp[n - 1][i][j]);
            }
        }
        return res;
    }
}
