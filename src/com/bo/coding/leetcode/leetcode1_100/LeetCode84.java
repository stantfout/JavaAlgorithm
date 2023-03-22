package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

import java.util.Deque;
import java.util.LinkedList;

@GoodQuestion
@Question(type = {TypeConst.MONOTONIC_STACK}, status = StatusEnum.FINAL_END)
public class LeetCode84 {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        //特判
        if (n == 0) {
            return 0;
        }
        int max = 0;
        //建立栈，Java官方推荐的是使用双端队列作为栈来使用
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        while (i < n) {
            //如果栈为空或者要入栈的元素i大于栈顶元素，就直接入栈
            if (stack.isEmpty() || arr[i] > arr[stack.getLast()]) {
                stack.addLast(i++);
            } else {
                //出栈
                int top = stack.pollLast();
                //计算面积时要注意确定好区间的范围
                if (!stack.isEmpty()) {
                    max = Math.max(max, arr[top] * (i - stack.getLast() - 1));
                } else {
                    max = Math.max(max, arr[top] * i);
                }
            }
        }
        //当栈不为空时，把栈顶元素出栈，进行计算
        while (!stack.isEmpty()) {
            int top = stack.pollLast();
            if (!stack.isEmpty()) {
                max = Math.max(max, arr[top] * (n - 1 - stack.getLast()));
            } else {
                max = Math.max(max, arr[top] * n);
            }
        }
        return max;
    }
}
