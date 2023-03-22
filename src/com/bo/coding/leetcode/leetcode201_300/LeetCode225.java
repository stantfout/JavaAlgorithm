package com.bo.coding.leetcode.leetcode201_300;

import java.util.LinkedList;
import java.util.Queue;

import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;

@Question(type = {TypeConst.DATA_STRUCTURE})
public class LeetCode225 {
    class MyStack {
        Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            int size = queue.size();
            queue.add(x);
            while (size -- != 0) {
                queue.add(queue.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
