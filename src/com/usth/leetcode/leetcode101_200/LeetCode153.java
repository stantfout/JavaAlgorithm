package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;

@Undone
@GoodQuestion("二分查找")
public class LeetCode153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
}
