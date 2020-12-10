package com.usth.competition.week214;

public class A {
    public int getMaximumGenerated(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        if (n == 0) {
            return 0;
        }
        arr[1] = 1;
        int max = 1;
        for (int i = 2; i < n + 1; i++) {
            if ((i & 1) == 0) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
