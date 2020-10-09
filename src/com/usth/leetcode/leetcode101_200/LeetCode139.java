package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.Undone;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Undone
public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        Set<String> dict = new HashSet<>(wordDict);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j]) {
                    dp[i] = dp[i] || dict.contains(s.substring(j,i));
                }
            }
        }
        return dp[n];
    }
}
