package com.bo.coding.leetcode.leetcode701_800;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

import java.util.Deque;
import java.util.LinkedList;

@GoodQuestion
@Question(type = {TypeConst.MONOTONIC_STACK}, status = StatusEnum.FINAL_END)
public class LeetCode739 {
    public int[] dailyTemperatures(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[arr.length];

        for (int i = 0 ; i < arr.length; i++) {
            if (stack.isEmpty() || arr[stack.getLast()] >= arr[i]) {
                stack.addLast(i);
            } else {
                while (!stack.isEmpty()) {
                    if (arr[stack.getLast()] < arr[i]) {
                        int index = stack.pollLast();
                        res[index] = i - index;
                    } else {
                        break;
                    }
                }
                stack.addLast(i);
            }
        }
        while (!stack.isEmpty()) {
            res[stack.pollLast()] = 0;
        }
        return res;
    }

}
