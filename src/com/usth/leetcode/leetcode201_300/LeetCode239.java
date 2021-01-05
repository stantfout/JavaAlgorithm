package com.usth.leetcode.leetcode201_300;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode239 {
    /*
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });

        for (int i = 0; i < k; i++) {
            pq.add(new int[]{nums[i],i});
        }
        res[0] = pq.peek()[0];

        for (int i = k; i < nums.length; i++) {
            pq.add(new int[]{nums[i], i});
            while (pq.peek()[1] < i - k + 1) {
                pq.poll();
            }
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }
    */

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        res[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
