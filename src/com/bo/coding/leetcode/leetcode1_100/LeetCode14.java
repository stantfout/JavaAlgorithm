package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@Question(type = {TypeConst.STRING}, status = StatusEnum.FINAL_END)
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
