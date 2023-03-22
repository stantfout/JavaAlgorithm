package com.bo.coding.leetcode.leetcode201_300;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;

import java.util.LinkedList;
import java.util.Queue;

@GoodQuestion
@Question(type = {TypeConst.TOPOLOGICAL_SORT})
public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        for (int[] p : prerequisites) {
            inDegrees[p[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            count++;
            for (int[] p : prerequisites) {
                if (p[0] == now) {
                    inDegrees[p[1]]--;
                    if (inDegrees[p[1]] == 0) {
                        queue.add(p[1]);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
