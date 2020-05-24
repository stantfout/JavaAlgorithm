package com.usth.leetcode.leetcode1_100;

public class LeetCode_5 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int maxLength = 0;
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String s1 = getLength(s, i, i, maxLength);
            if (maxLength < s1.length()) {
                result = s1;
                maxLength = s1.length();
            }
            String s2 = getLength(s, i, i + 1, maxLength);
            if (maxLength < s2.length()) {
                result = s2;
                maxLength = s2.length();
            }
        }
        return result;
    }

    private String getLength(String str, int i, int j, int maxLength) {
        while (i >= 0 && j < str.length()) {
            if (str.charAt(i) != str.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        int len = j - i - 1;
        return len > maxLength ? str.substring(i + 1, j) : "";
    }
}
