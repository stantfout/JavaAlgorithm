package com.usth.leetcode.leetcode1_100;

import java.util.*;

public class LeetCode_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer> > lists = new ArrayList<>();
        solve(nums,0, new LinkedList<>(), lists);
        return lists;
    }

    private void solve(int[] nums, int index, Deque<Integer> stack, List<List<Integer>> lists) {
        lists.add(new ArrayList<> (stack));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            stack.addLast(nums[i]);
            solve(nums, i + 1, stack, lists);
            stack.pollLast();
        }
    }

}
