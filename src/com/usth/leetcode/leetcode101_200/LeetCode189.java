package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;

@Undone
@GoodQuestion("数组操作")
public class LeetCode189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int i = 0;
        int j = n - 1;
        swapNums(nums,i,j);
        i = 0;
        j = k - 1;
        swapNums(nums, i, j);
        i = k;
        j = n - 1;
        swapNums(nums, i, j);
    }

    private void swapNums(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}
