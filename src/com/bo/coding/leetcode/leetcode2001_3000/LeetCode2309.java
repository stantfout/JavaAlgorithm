package com.bo.coding.leetcode.leetcode2001_3000;

import com.bo.coding.consts.TypeConst;
import com.bo.coding.annotation.Question;

@Question(type = {TypeConst.BIT_OPERATION})
public class LeetCode2309 {

    public String greatestLetter(String s) {
        int num = 'a' - 'A';
        for (char c = 'Z'; c >= 'A'; c = (char)(c - 1)) {
            String str1 = String.valueOf(c);
            String str2 = String.valueOf((char)(c + num));
            if (s.contains(str1) && s.contains(str2)) {
                return str1;
            }
        }

        return "";
    }
}
