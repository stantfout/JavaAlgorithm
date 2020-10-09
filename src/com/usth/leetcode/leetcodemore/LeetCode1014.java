package com.usth.leetcode.leetcodemore;

import com.usth.annotation.Undone;

@Undone
public class LeetCode1014 {
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
