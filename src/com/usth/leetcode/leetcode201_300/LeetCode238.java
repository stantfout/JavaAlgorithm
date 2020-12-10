package com.usth.leetcode.leetcode201_300;

import com.usth.annotation.FinalEnd;
import com.usth.annotation.GoodQuestion;

import java.util.Arrays;

@FinalEnd
@GoodQuestion("思维题")
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
