package com.bo.coding.competition.week217;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class B {
    public int[] mostCompetitive(int[] nums, int k) {
        List<Integer> list = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            Integer num = new Integer(nums[i]);
            list.add(num);
            pq.add(num);
        }
        for (int i = k; i < nums.length; i++) {
            Integer num = new Integer(nums[i]);
            if (num <= pq.peek()) {
                Integer poll = pq.poll();
                list.remove(poll);
                list.add(num);
                pq.add(num);
            }
        }
        int[] res = new int[k];
        int i = 0;
        for (Integer integer : list) {
            res[i++] = integer;
        }
        return res;
    }
}
