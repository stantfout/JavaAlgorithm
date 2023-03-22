package com.bo.coding.leetcode.leetcode201_300;

import com.bo.coding.annotation.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Question
public class LeetCode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        Arrays.sort(nums);
        int start;
        int end;
        for (int i = 0; i < nums.length; i++) {
            start = nums[i];
            while ((i < nums.length - 1) && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            end = nums[i];
            StringBuilder sb = new StringBuilder();
            sb.append(start);
            if (end != start) {
                sb.append("->");
                sb.append(end);

            }
            res.add(sb.toString());
        }
        return res;
    }
}
