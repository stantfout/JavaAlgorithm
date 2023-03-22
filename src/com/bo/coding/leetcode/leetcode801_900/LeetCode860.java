package com.bo.coding.leetcode.leetcode801_900;

import com.bo.coding.annotation.Question;

@Question
public class LeetCode860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five <= 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (ten <= 0) {
                    if (five < 3) {
                        return false;
                    }
                    five -= 3;
                } else {
                    ten--;
                    if (five <= 0) {
                        return false;
                    }
                    five--;
                }
            }
        }
        return true;
    }
}
