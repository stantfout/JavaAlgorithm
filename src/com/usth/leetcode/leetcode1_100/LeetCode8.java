package com.usth.leetcode.leetcode1_100;

import com.usth.annotation.Undone;

@Undone
public class LeetCode8 {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int index = 0;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            return str.charAt(index) == '+' ? getSum(str, index + 1, true) : getSum(str, index + 1, false);
        } else if (Character.isDigit(str.charAt(index))) {
            return getSum(str, index, true);
        } else {
            return 0;
        }
    }

    private int getSum(String str, int index, boolean flag) {
        int sum = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int num = str.charAt(index) - '0';
            index++;
            if (sum > 214748364) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else if (sum == 214748364) {
                if (flag && num >= 7) {
                    return Integer.MAX_VALUE;
                }
                if (!flag && num >= 8) {
                    return Integer.MIN_VALUE;
                }
            }
            sum = sum * 10 + num;
        }
        return flag ? sum : -sum;
    }

    public static void main(String[] args) {
        LeetCode8 le = new LeetCode8();
        System.out.println(le.myAtoi(" "));
    }
}
