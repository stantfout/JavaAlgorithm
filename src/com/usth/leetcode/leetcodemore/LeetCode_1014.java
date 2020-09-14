package com.usth.leetcode.leetcodemore;

public class LeetCode_1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int max = A[0] + 0;
        for (int i = 1; i < A.length; ++i) {
            res = Math.max(res, max + A[i] - i);
            max = Math.max(max, A[i] + i);
        }
        return res;
    }
}
