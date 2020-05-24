package com.usth.leetcode.leetcode1_100;

public class LeetCode_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int count = 0;
        int[] hash = new int[128];
        hash[s.charAt(i)] = 1;
        while (j < s.length()) {
            if (hash[s.charAt(j)] == 0) {
                hash[s.charAt(j)] = 1;
                j++;
            } else {
                count = Math.max(count,j - i);
                while (s.charAt(i) != s.charAt(j)) {
                    hash[s.charAt(i)] = 0;
                    i++;
                }
                i++;
                j++;
            }
        }
        count = Math.max(count,j - i);
        return count;
    }
}
