package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.HASH, TypeConst.SLIDING_WINDOW}, status = StatusEnum.FINAL_END)
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[128];
        int pre = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            pre = Math.max(pre, hash[s.charAt(i)]);
            res = Math.max(res, i - pre + 1);
            hash[s.charAt(i)] = i + 1;
        }
        return res;
    }
    /*
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;
        int count = 0;
        int[] hash = new int[128];
        hash[s.charAt(i)] = 1;
        while (j < s.length()) {
            if (hash[s.charAt(j)] == 0) {
                hash[s.charAt(j)] = 1;
                j++;
            } else {
                count = Math.max(count,j - i);
                while (s.charAt(i) != s.charAt(j)) {
                    hash[s.charAt(i)] = 0;
                    i++;
                }
                i++;
                j++;
            }
        }
        count = Math.max(count,j - i);
        return count;
    }
     */
}
