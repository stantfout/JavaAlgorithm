package com.bo.coding.leetcode.leetcode1001_2000;

import com.bo.coding.consts.TypeConst;
import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;

@GoodQuestion
@Question(type = {TypeConst.PREFIX_AND,TypeConst.THINKING})
public class LeetCode1664 {

    public int waysToMakeFair(int[] nums) {
        int res = 0;
        int length = nums.length;
        if (length <= 1)
            return 1;
        
        // 奇数位和数组
        int[] oddSumArr = new int[length / 2 + 2];
        // 偶数位和数组
        int[] evenSumArr = new int[length / 2 + 2];

        // 计算前缀和数组
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (i >= 2) {
                if ((i & 1) == 0) {
                    evenSumArr[i / 2]  = evenSumArr[(i - 2) / 2] + num;
                } else {
                    oddSumArr[i / 2] = oddSumArr[(i - 2) / 2] + num;
                }
            } else {
                if ((i & 1) == 0) {
                    evenSumArr[i / 2] = num;
                } else {
                    oddSumArr[i / 2] = num;
                }
            }
        }

        // 讨论删除 i 位置的情况
        for (int i = 0; i < length; i++) {
            int num = nums[i];

            int oddSum = 0;
            int evenSum = 0;

            if ((i & 1) == 0) {
                oddSum = ((i / 2) - 1 >= 0 ? oddSumArr[(i / 2) - 1] : 0) + (evenSumArr[(length - 1) / 2] - evenSumArr[(i / 2)]);
                evenSum = evenSumArr[i / 2] + (oddSumArr[(length - 2) / 2] - ((i / 2) - 1 >= 0 ? oddSumArr[(i / 2) - 1] : 0));
                evenSum -= num;
            } else {
                oddSum = oddSumArr[i / 2] + (evenSumArr[(length - 1) / 2] - evenSumArr[(i / 2)]);
                evenSum = evenSumArr[i / 2] + (oddSumArr[(length - 2) / 2] - oddSumArr[(i / 2)]);
                oddSum -= num;
            }

            if (oddSum == evenSum)
                res++;
        }
        return res;
    }
}
