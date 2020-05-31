package com.usth.competition.week191;
import java.util.*;

public class C {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, ArrayList<Integer>> to = new HashMap<> ();
        Map<Integer, ArrayList<Integer>> from = new HashMap<> ();
        for (int[] arr : connections) {
            ArrayList<Integer> toList = to.getOrDefault(arr[0], new ArrayList<>());
            ArrayList<Integer> fromList = from.getOrDefault(arr[1], new ArrayList<>());
            toList.add(arr[1]);
            fromList.add(arr[0]);
            to.put(arr[0],toList);
            from.put(arr[1],fromList);
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[n];
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            vis[poll] = true;

            ArrayList<Integer> toList = to.get(poll);
            if (toList != null) {
                for (Integer ax : toList) {
                    if (!vis[ax]) {
                        queue.add(ax);
                        count++;
                    }
                }
            }

            ArrayList<Integer> fromList = from.get(poll);
            if (fromList != null) {
                for (Integer fromIndex : fromList) {
                    if (vis[fromIndex]) {
                        continue;
                    }
                    queue.add(fromIndex);
                }
            }
        }
        return count;
    }
}
