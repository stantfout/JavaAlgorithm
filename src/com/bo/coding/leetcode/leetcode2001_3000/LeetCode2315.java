package com.bo.coding.leetcode.leetcode2001_3000;

import com.bo.coding.consts.TypeConst;
import com.bo.coding.annotation.Question;

@Question(type = TypeConst.STRING)
public class LeetCode2315 {
    public int countAsterisks(String s) {
        int res = 0;
        int stack = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack == 0 && ch == '*') {
                res++;
            }
            if (ch == '|') {
                stack++;
            }
            stack %= 2;
        }

        return res;
    }
}
