package com.usth.leetcode.leetcode1_100;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Undone
@GoodQuestion("递归")
public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        solve(nums, 0, new LinkedList<>(), lists);
        return lists;
    }

    private void solve(int[] nums, int index, Deque<Integer> stack, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(stack));
        for (int i = index; i < nums.length; i++) {
            stack.addLast(nums[i]);
            solve(nums, i + 1, stack, lists);
            stack.pollLast();
        }
    }
}
