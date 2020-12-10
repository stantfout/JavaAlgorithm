package com.usth.leetcode.leetcode201_300;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Undone
@GoodQuestion("递归")
public class LeetCode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer> > res = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        solve(k,0,n,res, stack);
        return res;
    }

    private void solve(int k, int start, int sum, List<List<Integer>> res, Deque<Integer> stack) {
        if (k < 0 || sum < 0) {
            return;
        }
        if (k == 0 && sum == 0) {
            res.add(new ArrayList<> (stack));
        }
        for (int i = start; i <= 9; i++) {
            stack.addLast(i);
            solve(k - 1, i + 1, sum - i, res, stack);
            stack.pollLast();
        }
    }
}
