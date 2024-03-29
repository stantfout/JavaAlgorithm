package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

import java.util.Arrays;

@Question(type = {TypeConst.DOUBLE_POINT}, status = StatusEnum.FINAL_END)
public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int dif = sum - target;
                if (dif > 0) {
                    right--;
                    if (min > dif) {
                        min = dif;
                        res = sum;
                    }
                } else if (dif < 0) {
                    left++;
                    if (min > -dif) {
                        min = -dif;
                        res = sum;
                    }
                } else {
                    return target;
                }
            }
        }
        return res;
    }
}
