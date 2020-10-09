package com.usth.leetcode.leetcode201_300;

import com.usth.annotation.Undone;

import java.util.Deque;
import java.util.LinkedList;

@Undone
public class LeetCode227 {
    public int calculate(String str) {
        str = str.replace(" ", "");
        int index = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (index < str.length()) {
            if (str.charAt(index) == '*' || str.charAt(index) == '/') {
                char sign = str.charAt(index++);
                int num = 0;
                while (index < str.length() && Character.isDigit(str.charAt(index))) {
                    num = num * 10 + str.charAt(index++) - '0';
                }
                int top = stack.pollLast();
                stack.addLast(sign == '*' ? top * num : top / num);

            } else {
                int num = 0;
                boolean flag = str.charAt(index) != '-';
                if (str.charAt(index) == '+' || str.charAt(index) == '-') {
                    index++;
                }
                while (index < str.length() && Character.isDigit(str.charAt(index))) {
                    num = num * 10 + str.charAt(index++) - '0';
                }
                num = flag ? num : -num;
                stack.addLast(num);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            Integer num = stack.pollLast();
            sum += num;
        }
        return sum;
    }
}
