package com.usth.leetcode.leetcode1_100;

import com.usth.annotation.FinalEnd;

@FinalEnd
public class LeetCode7 {
    public int reverse(int x) {
        int res = 0;
        int temp;
        while (x != 0) {
            temp = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            res = res * 10 + temp;
        }
        return res;
    }
}
