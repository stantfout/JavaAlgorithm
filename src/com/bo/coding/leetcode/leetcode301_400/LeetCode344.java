package com.bo.coding.leetcode.leetcode301_400;

import com.bo.coding.annotation.Question;

@Question
public class LeetCode344 {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length;
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
