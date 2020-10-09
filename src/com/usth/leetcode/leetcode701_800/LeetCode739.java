package com.usth.leetcode.leetcode701_800;

import com.usth.annotation.FinalEnd;

import java.util.Deque;
import java.util.LinkedList;

@FinalEnd
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
