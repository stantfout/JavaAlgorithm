package com.bo.coding.competition.week194;

public class A {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int xor = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        return xor;
    }
}
