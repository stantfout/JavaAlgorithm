package com.bo.coding.competition.week209;

public class A {
    public int specialArray(int[] nums) {
        int[] hash = new int[1005];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]] ++;
        }
        for (int i = hash.length - 2; i >= 0; i--) {
            hash[i] += hash[i + 1];
            if (hash[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
