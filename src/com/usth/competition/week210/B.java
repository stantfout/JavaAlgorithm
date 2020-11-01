package com.usth.competition.week210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            List<Integer> list = map.getOrDefault(road[0], new ArrayList<>());
            list.add(road[1]);
            map.put(road[0], list);
            list = map.getOrDefault(road[1], new ArrayList<>());
            list.add(road[0]);
            map.put(road[1], list);
        }
        int max = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (Map.Entry<Integer, List<Integer>> entry2 : map.entrySet()) {
                if (entry.getKey().equals(entry2.getKey())) {
                    continue;
                }
                int size = entry.getValue().size();
                List<Integer> value = entry2.getValue();
                int size1 = value.size();
                int sum = size + size1;
                if (value.contains(entry.getKey())) {
                    sum--;
                }
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}
