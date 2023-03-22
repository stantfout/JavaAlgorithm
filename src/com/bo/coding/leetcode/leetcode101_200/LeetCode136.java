package com.bo.coding.leetcode.leetcode101_200;

import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@Question(type = {TypeConst.BIT_OPERATION}, status = StatusEnum.FINAL_END)
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
