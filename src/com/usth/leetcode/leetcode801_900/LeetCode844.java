package com.usth.leetcode.leetcode801_900;

import com.usth.annotation.Undone;

@Undone
public class LeetCode844 {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int s1 = 0;
        int s2 = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    i--;
                    s1++;
                } else if (s1 != 0) {
                    s1--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    j--;
                    s2++;
                } else if (s2 != 0) {
                    s2--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
            i--;j--;
        }
        return true;
    }
}
