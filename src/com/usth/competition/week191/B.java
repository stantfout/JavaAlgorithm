package com.usth.competition.week191;

import java.util.Arrays;

public class B {
    private static final int MOD = (int) (1e9 + 7);
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long high = getMax(h,horizontalCuts);
        long width = getMax(w,verticalCuts);
        return (int) ((high * width) % MOD);
    }

    private long getMax(int end, int[] arr) {
        long max = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i] - arr[i - 1]);
        }
        max = Math.max(max, end - arr[n - 1]);
        return max;
    }
}
