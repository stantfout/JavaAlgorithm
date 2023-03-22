package com.bo.coding.leetcode.leetcode101_200;

import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

import	java.util.Deque;
import java.util.LinkedList;

@Question(type = {TypeConst.THINKING, TypeConst.DATA_STRUCTURE}, status = StatusEnum.FINAL_END)
public class LeetCode150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (judge(token)) {
                int a = stack.pollLast();
                int b = stack.pollLast();
                stack.addLast(solve(a,b,token));
            } else {
                stack.addLast(Integer.parseInt(token));
            }
        }
        return stack.pollLast();
    }

    private int solve(int a, int b, String token) {
        switch (token) {
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            case "/" : return a / b;
        }
        return 0;
    }


    private boolean judge(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

}
