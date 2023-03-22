package com.bo.coding.leetcode.leetcode201_300;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

import	java.util.LinkedList;
import	java.util.Queue;

@GoodQuestion
@Question(type = {TypeConst.TOPOLOGICAL_SORT}, status = StatusEnum.FINAL_END)
public class LeetCode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        int[] inDegrees = new int[numCourses];
        for (int[] p : prerequisites) {
            inDegrees[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<> ();
        for (int i = 0; i < inDegrees.length; ++i) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            res[count++] = poll;
            for (int[] p : prerequisites) {
                if (p[1] == poll) {
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0) {
                        queue.add(p[0]);
                    }
                }
            }

        }
        return count == numCourses ? res : new int[0];
    }
}
