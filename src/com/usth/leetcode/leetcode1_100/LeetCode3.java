package com.usth.leetcode.leetcode1_100;

import com.usth.annotation.FinalEnd;

@FinalEnd
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[128];
        int pre = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            pre = Math.max(pre, hash[s.charAt(i)]);
            res = Math.max(res, i - pre + 1);
            hash[s.charAt(i)] = i + 1;
        }
        return res;
    }
}
