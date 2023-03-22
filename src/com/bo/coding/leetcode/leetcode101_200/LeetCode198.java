package com.bo.coding.leetcode.leetcode101_200;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.DYNAMIC_PROGRAMMING}, status = StatusEnum.FINAL_END)
public class LeetCode198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(first,nums[1]);
        for (int i = 2; i < n; i++) {
           int max = Math.max(second, first + nums[i]);
           first = second;
           second = max;
        }
        return second;
    }
}
