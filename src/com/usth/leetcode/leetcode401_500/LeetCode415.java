package com.usth.leetcode.leetcode401_500;

import com.usth.annotation.Undone;

@Undone
public class LeetCode415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int num = flag;
            if (i >= 0) {
                num += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                num += num2.charAt(j) - '0';
                j--;
            }
            flag = num / 10;
            num %= 10;
            sb.append(num);
        }
        if (flag != 0) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }
}
