package com.bo.coding.leetcode.leetcode901_1000;

import com.bo.coding.annotation.Question;

@Question
public class LeetCode977 {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] arr = new int[n];
        int i = 0;
        int j = n - 1;
        int index = n - 1;
        while (i < j) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                arr[index--] = A[i] * A[i];
                i++;
            } else {
                arr[index--] = A[j] * A[j];
                j--;
            }
        }
        return arr;
    }
}
