package com.usth.leetcode.leetcode401_500;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;

import java.util.HashMap;
import java.util.Map;

@Undone
@GoodQuestion("分组+hash")
public class LeetCode454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int key = A[i] + B[j];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int key = C[i] + D[j];
                count += map.getOrDefault(-key, 0);
            }
        }

        return count;
    }
}
