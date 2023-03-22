package com.bo.coding.leetcode.leetcode201_300;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

import java.util.Arrays;

@GoodQuestion
@Question(type = {TypeConst.THINKING}, status = StatusEnum.FINAL_END)
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int n =nums.length;
        int[] output = new int[n];
        Arrays.fill(output,1);
        int left = 1;
        int right = 1;
        int i = 0;
        int j = n - 1;
        while (i < n) {
            output[i] *= left;
            output[j] *= right;
            left *= nums[i];
            right *= nums[j];
            i++;
            j--;
        }
        return output;
    }
}
