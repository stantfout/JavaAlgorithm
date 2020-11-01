package com.usth.competition.week210;

import java.util.Deque;
import java.util.LinkedList;

public class A {
    public int maxDepth(String s) {
        int depth = 0;
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addLast(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                depth = Math.max(depth, stack.size());
                stack.pollLast();
            }
        }
        return depth;
    }
}
