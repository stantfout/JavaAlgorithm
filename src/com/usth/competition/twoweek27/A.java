package com.usth.competition.twoweek27;

import java.util.HashMap;
import java.util.Map;

public class A {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i],map.getOrDefault(target[i],0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            Integer cnt = map.getOrDefault(arr[i], -1);
            if (cnt == -1) {
                return false;
            }
            map.put(arr[i],cnt - 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
