package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;

import java.util.*;

@GoodQuestion
@Question(type = {TypeConst.RECURSION})
public class LeetCode90 {
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
