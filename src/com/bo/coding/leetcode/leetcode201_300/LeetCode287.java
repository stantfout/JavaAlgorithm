package com.bo.coding.leetcode.leetcode201_300;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.BINARY_SEARCH, TypeConst.DOUBLE_POINT}, status = StatusEnum.FINAL_END)
public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int left = 1;
        int right = n;
        int mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (judge(nums,mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private boolean judge(int[] arr, int value) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= value) {
                ans++;
            }
        }
        return ans <= value;
    }

}
