package com.usth.competition.twoweek27;

import java.util.*;

public class C {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] dp = new boolean[n][n];
        for (int[] p : prerequisites) {
            dp[p[0]][p[1]] = true;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = dp[i][j] || (dp[i][k] && dp[k][j]);
                }
            }
        }

        List<Boolean> res = new ArrayList<> ();
        for (int[] query : queries) {
            res.add(dp[query[0]][query[1]]);
        }
        return res;
    }
}
