package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Question
public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if ((j > i + 1) && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        do {
                            left++;
                        }
                        while (left < n && nums[left] == nums[left - 1]);
                        do {
                            right--;
                        } while (right >= 0 && nums[right] == nums[right + 1]);
                    } else if (sum < target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
