package com.usth.competition.week200;

import java.util.HashMap;
import java.util.Map;

public class D {
    private static final int MOD = 1000000007;
    public int maxSum(int[] nums1, int[] nums2) {
        long count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i],0) + 1);
        }
        int i = 0;
        int j = 0;
        while (i < nums1.length || j < nums2.length) {
            long sum1 = 0;
            long sum2 = 0;
            while (i < nums1.length && map.get(nums1[i]) == 1) {
                sum1 = sum1 + nums1[i];
                i++;
            }
            while (j < nums2.length && map.get(nums2[j]) == 1) {
                sum2 = sum2 + nums2[j];
                j++;
            }
            count = (count + Math.max(sum1,sum2)) % MOD;
            if (i < nums1.length) {
                count = (count + nums1[i]) % MOD;
                i++;
                j++;
            }
        }
        return (int) (count % MOD);
    }
}
