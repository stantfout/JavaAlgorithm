package com.usth.competition.week194;
import	java.util.Set;
import	java.util.Queue;

import java.util.*;

public class C {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < rains.length; ++i) {
            if (!map.containsKey(rains[i])) {
                map.put(rains[i], new LinkedList<>());
            } else {
                map.get(rains[i]).add(i);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<> ();
        int[] res = new int[rains.length];
        Set<Integer> set = new HashSet<> ();

        for (int i = 0; i < rains.length; ++i) {
            if (rains[i] != 0) {
                if (set.contains(rains[i])) {
                    return new int[0];
                }
                res[i] = -1;
                set.add(rains[i]);
                Queue<Integer> queue = map.get(rains[i]);
                if (!queue.isEmpty()) {
                    pq.add(queue.poll());
                }
            } else {
                if (!pq.isEmpty()) {
                    res[i] = rains[pq.poll()];
                    set.remove(res[i]);
                } else {
                    res[i] = 1;
                }
            }
        }
        return res;
    }
}
