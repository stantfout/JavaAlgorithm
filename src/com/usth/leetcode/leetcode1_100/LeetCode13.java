package com.usth.leetcode.leetcode1_100;

import com.usth.annotation.Undone;

import java.util.HashMap;
import java.util.Map;

@Undone
public class LeetCode13 {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int pre = i == 0 ? Integer.MAX_VALUE : map.get(s.charAt(i - 1));
            int num = map.get(s.charAt(i));
            if (num > pre) {
                num -= pre;
                i--;
            }
            sum += num;
        }
        return sum;
    }
}
