package com.bo.coding.competition.twoweek40;

import java.util.Deque;
import java.util.LinkedList;

public class C {
    class FrontMiddleBackQueue {

        Deque<Integer> queue1;
        Deque<Integer> queue2;

        public FrontMiddleBackQueue() {
            queue1 = new LinkedList<> ();
            queue2 = new LinkedList<> ();
        }

        public void pushFront(int val) {
            queue1.addFirst(val);
        }

        public void pushMiddle(int val) {
            if (queue1.size() > queue2.size()) {
                queue2.addFirst(val);
            } else {
                queue1.addLast(val);
            }
        }

        public void pushBack(int val) {
            queue2.addLast(val);
        }

        public int popFront() {
            return queue1.isEmpty() ? -1 : queue1.pollFirst();
        }

        public int popMiddle() {
            if (queue1.isEmpty() && queue2.isEmpty()) {
                return -1;
            }
            return queue1.size() >= queue2.size() ? queue1.pollLast() : queue2.pollFirst();
        }

        public int popBack() {
            return queue2.isEmpty() ? -1 : queue2.pollLast();
        }
    }
}
