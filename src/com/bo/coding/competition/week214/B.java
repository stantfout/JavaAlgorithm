package com.bo.coding.competition.week214;

import java.util.*;

public class B {
    public int minDeletions(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : hash) {
            int count = map.getOrDefault(number, 0);
            if (count >= 1) {
                
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value != 1) {
                res += value - 1;
            }
            map.put(key - 1, map.getOrDefault(key - 1,0) + value - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        B b = new B();
        b.minDeletions("aaabbbcc");
    }
}
