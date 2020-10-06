package com.usth.leetcode.leetcode1_100;

import java.util.*;

public class LeetCode_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permutation(nums,0,new HashSet<>(), new LinkedList<> (),lists);
        return lists;
    }

    private void permutation(int[] nums, int index, Set<Integer> vis, Deque<Integer> stack,List<List<Integer>> lists) {
        if (index == nums.length) {
            lists.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis.contains(nums[i])) {
                vis.add(nums[i]);
                stack.addLast(nums[i]);
                permutation(nums, index + 1, vis,stack,lists);
                vis.remove(nums[i]);
                stack.removeLast();
            }
        }
    }
}
