package com.usth.leetcode.leetcode1_100;

import com.usth.annotation.FinalEnd;

@FinalEnd
public class LeetCode9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev  = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }
}
