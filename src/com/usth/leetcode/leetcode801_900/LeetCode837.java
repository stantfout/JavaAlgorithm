package com.usth.leetcode.leetcode801_900;

import com.usth.annotation.FinalEnd;
import com.usth.annotation.GoodQuestion;

@FinalEnd
@GoodQuestion("动态规划+前缀和优化")
public class LeetCode837 {
    public double new21Game(int N, int K, int W) {
        //特判K=0时结果为1
        if (K == 0) {
            return 1;
        }
        double[] dp = new double[N + 1];
        double[] sum = new double[N + 1];
        dp[0] = 1;
        sum[0] = 1;
        double tmp = (1.0 / W);
        for (int i = 1; i <= N; i++) {
            //这里通过前缀和求解时要注意边界问题
            double sum1 = Math.max(0, i - W) - 1 >= 0 ? sum[Math.max(0, i - W) - 1] : 0;
            double sum2 = sum[Math.min(i - 1, K - 1)];
            dp[i] = (sum2 - sum1) * tmp;
            sum[i] = sum[i - 1] + dp[i];
        }
        double res = 0;
        for (int i = K; i <= N; ++i) {
            res += dp[i];
        }
        return res;
    }
}
