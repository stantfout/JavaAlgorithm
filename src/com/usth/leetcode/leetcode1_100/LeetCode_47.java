package com.usth.leetcode.leetcode1_100;

import java.util.*;

public class LeetCode_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        permute(nums,0, new int[nums.length], new LinkedList<>(), lists);
        return lists;
    }

    private void permute(int[] nums, int index, int[] vis, Deque<Integer> stack, List<List<Integer>> lists) {
        if (index == nums.length) {
            lists.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] == 0) {
                vis[i] = 1;
                stack.addLast(nums[i]);
                permute(nums,index + 1, vis, stack, lists);
                vis[i] = 0;
                stack.pollLast();
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }
}
