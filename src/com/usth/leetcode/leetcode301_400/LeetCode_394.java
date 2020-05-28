package com.usth.leetcode.leetcode301_400;

import javafx.util.Pair;
import sun.applet.Main;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode_394 {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> strStack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                strStack.addLast(res.toString());
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                Integer num = numStack.pollLast();
                while (num -- != 0) {
                    temp.append(res);
                }
                res = new StringBuilder(strStack.pollLast() + temp);
            } else if (isNum(c)) {
                int begin = i;
                while (isNum(s.charAt(i + 1))) {
                    i++;
                }
                numStack.addLast(Integer.valueOf(s.substring(begin, i + 1)));
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    private boolean isNum(char c) {
        return c >= '0' && c <='9';
    }

}
