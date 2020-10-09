package com.usth.leetcode.leetcode901_1000;

import com.usth.annotation.FinalEnd;

import java.util.HashMap;
import java.util.Map;

@FinalEnd
public class LeetCode974 {
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
