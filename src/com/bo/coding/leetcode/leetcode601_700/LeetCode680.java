package com.bo.coding.leetcode.leetcode601_700;

import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@Question(status = StatusEnum.FINAL_END, type = {TypeConst.STRING})
public class LeetCode680 {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return judge(s,i, j -1) || judge(s, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }
    private boolean judge(String str, int i , int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
