package com.usth.leetcode.leetcode601_700;

public class LeetCode_680 {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return judge(s,i, j -1) || judge(s, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }
    private boolean judge(String str, int i , int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
