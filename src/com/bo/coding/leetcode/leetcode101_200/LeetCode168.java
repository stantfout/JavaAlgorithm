package com.bo.coding.leetcode.leetcode101_200;

import com.bo.coding.annotation.Question;

@Question
public class LeetCode168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int temp = ((n - 1) % 26) + 1;
            char c = (char) ('A' + temp);
            sb.append(c);
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
