package com.bo.coding.leetcode.leetcode101_200;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

import java.util.HashSet;
import java.util.Set;

@GoodQuestion
@Question(type = {TypeConst.THINKING}, status = StatusEnum.FINAL_END)
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int now = num;
            int count = 1;
            while (set.contains(now + 1)) {
                now++;
                count++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
