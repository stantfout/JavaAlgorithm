package com.bo.coding.competition.week200;

import java.util.Deque;
import java.util.LinkedList;

public class B {
    public int getWinner(int[] arr, int k) {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(arr[0]);
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                count ++;
                queue.add(arr[i]);
            } else {
                count = 1;
                queue.add(queue.pollFirst());
                queue.addFirst(arr[i]);
            }
            if (count == k) {
                break;
            }
        }
        return queue.peek();
    }
}
