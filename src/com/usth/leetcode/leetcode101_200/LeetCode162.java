package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;

@Undone
@GoodQuestion("二分查找")
public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
