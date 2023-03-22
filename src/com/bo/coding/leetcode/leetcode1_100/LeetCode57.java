package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.Question;

import java.util.ArrayList;
import java.util.List;

@Question
public class LeetCode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //特判
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        //合并
        boolean flag = false;
        List<int[]> res = new ArrayList<>();
        int start;
        int end;
        if (newInterval[0] <= intervals[0][0]) {
            start = newInterval[0];
            end = newInterval[1];
        } else {
            start = intervals[0][0];
            end = intervals[0][1];
        }
        for (int i = 0; i < intervals.length;) {
            int[] interval = intervals[i];
            int nStart;
            int nEnd;
            if (!flag && newInterval[0] <= interval[0]) {
                nStart = newInterval[0];
                nEnd = newInterval[1];
                flag = true;
            } else {
                nStart = interval[0];
                nEnd = interval[1];
                i++;
            }
            if (nStart > end) {
                res.add(new int[]{start, end});
                start = nStart;
                end = nEnd;
            } else {
                end = Math.max(end, nEnd);
            }
        }
        if (!flag) {
            int nStart = newInterval[0];
            int nEnd = newInterval[1];
            if (nStart > end) {
                res.add(new int[]{start, end});
                start = nStart;
                end = nEnd;
            } else {
                end = Math.max(end, nEnd);
            }
        }
        res.add(new int[]{start, end});
        //转换
        int[][] arr = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
