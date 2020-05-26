package com.usth.leetcode.leetcode900_1000;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_974 {
    public int subarraysDivByK(int[] arr, int K) {
        int n = arr.length;
        int res = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int key = (sum % K + K) % K;
            int ans = map.getOrDefault(key,0);
            res += ans;
            map.put(key, ans + 1);
        }
        return res;
    }
}
