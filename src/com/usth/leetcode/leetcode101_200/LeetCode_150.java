package com.usth.leetcode.leetcode101_200;

import	java.util.Deque;
import java.util.LinkedList;

public class LeetCode_150 {
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
