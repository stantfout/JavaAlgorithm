package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Undone
@GoodQuestion("动态规划")
public class LeetCode139 {

    //动态规划
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

    /*递归
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return solve(s,dict,0);
    }

    private boolean solve(String str, Set<String> wordDict, int start) {
        if (str.length() == start) {
            return true;
        }
        boolean flag = false;
        for (int i = start; i < str.length(); i++) {
            if (wordDict.contains(str.substring(start,i + 1))) {
                flag = flag || solve(str, wordDict, i + 1);
            }
        }
        return flag;
    }
    */

    /* 记忆化搜索
    int[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        Set<String> dict = new HashSet<>(wordDict);
        return solve(s,dict,0);
    }

    private boolean solve(String str, Set<String> wordDict, int start) {
        if (str.length() == start) {
            return true;
        }
        if (dp[start] != -1) {
            return dp[start] == 1;
        }
        boolean flag = false;
        for (int i = start; i < str.length(); i++) {
            if (wordDict.contains(str.substring(start,i + 1))) {
                flag = flag || solve(str, wordDict, i + 1);
            }
        }
        dp[start] = flag ? 1 : 0;
        return flag;
    }
     */
}
