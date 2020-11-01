package com.usth.competition.week211;

import java.util.HashMap;
import java.util.Map;

public class A {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = 0;
        boolean flag = false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                flag = true;
                max = Math.max(max, i - map.get(s.charAt(i)) - 1);
            } else {
                map.put(s.charAt(i),i);
            }
        }
        return flag ? max : -1;
    }
}
