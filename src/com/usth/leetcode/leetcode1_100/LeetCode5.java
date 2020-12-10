package com.usth.leetcode.leetcode1_100;

import com.usth.annotation.FinalEnd;
import com.usth.annotation.GoodQuestion;

@FinalEnd
@GoodQuestion("多解法:中心扩展/动态规划/马拉车")
public class LeetCode5 {

    //    public String longestPalindrome(String s) {
//        int n = s.length();
//        if (n == 0) {
//            return s;
//        }
//        boolean[][] dp = new boolean[n][n];
//        int max = 0; int l = 0; int r = 0;
//        for (int len = 1; len <= n; len++) {
//            for (int i = 0; i + len - 1 < n; i++) {
//                int j = i + len - 1;
//                if (s.charAt(i) == s.charAt(j)) {
//                    if (len <= 2) {
//                        dp[i][j] = true;
//                    } else {
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                }
//                if (dp[i][j] && max < len) {
//                    max = len;
//                    l = i;
//                    r = j;
//                }
//            }
//        }
//        return s.substring(l,r + 1);
//    }
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return s;
        }
        String res = "";
        for (int i = 0; i < n; i++) {
            String s1 = getStr(s,i,i);
            String s2 = getStr(s,i,i + 1);
            if (res.length() < s1.length() || res.length() < s2.length()) {
                res = s1.length() > s2.length() ? s1 : s2;
            }
        }
        return res;
    }

    private String getStr(String str, int i, int j) {
        while (i >= 0 && j < str.length()) {
            if (str.charAt(i) != str.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return str.substring(i + 1, j);
    }
}
