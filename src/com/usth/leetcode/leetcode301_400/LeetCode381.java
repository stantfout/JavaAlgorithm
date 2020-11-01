package com.usth.leetcode.leetcode301_400;

import com.usth.annotation.Undone;
import java.util.*;

@Undone
public class LeetCode381 {
    class RandomizedCollection {
        Map<Integer, Set<Integer>> map;
        List<Integer> nums;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            map = new HashMap<>();
            nums = new ArrayList<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            nums.add(val);
            Set<Integer> index = map.getOrDefault(val, new HashSet<>());
            index.add(nums.size() - 1);
            map.put(val, index);
            return index.size() == 1;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            Set<Integer> index = map.getOrDefault(val, new HashSet<>());
            if (index.size() == 0) {
                return false;
            }
            int n = nums.size() - 1;
            int lastNum = nums.get(n);
            Set<Integer> last = map.get(lastNum);
            Iterator<Integer> it = index.iterator();
            Integer removeIndex = it.next();
            index.remove(removeIndex);
            nums.set(removeIndex, lastNum);
            nums.remove(n);
            last.add(removeIndex);
            last.remove(n);
            map.put(lastNum, last);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return nums.get((int) (Math.random() * nums.size()));
        }
    }
}
