package com.bo.coding.leetcode.leetcode901_1000;

import com.bo.coding.annotation.Question;

@Question
public class LeetCode941 {
    public boolean validMountainArray(int[] A) {
        int n = A.length;
        int i;
        for (i = 0; i < n - 1; i++) {
            if (A[i] >= A[i + 1]) {
                break;
            }
        }
        if (i == 0 || i == n - 1) {
            return false;
        }
        for (;i < n - 1; i++) {
            if (A[i] <= A[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
