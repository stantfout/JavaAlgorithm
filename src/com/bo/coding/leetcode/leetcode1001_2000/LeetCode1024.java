package com.bo.coding.leetcode.leetcode1001_2000;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.GREEDY_ALGORITHM})
public class LeetCode1024 {
    public int videoStitching(int[][] clips, int T) {
        int[] maxn = new int[T + 1];
        for (int[] clip : clips) {
            if (clip[0] <= T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        int cnt = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i <= T; i++) {
            max = Math.max(max,maxn[i]);
            if (i == max) {
                return -1;
            }
            if (i == end) {
                cnt++;
                end = Math.max(end,max);
            }
        }
        return cnt;
    }
    /* 未优化
    public int videoStitching(int[][] clips, int T) {
        int cnt = 1;
        Arrays.sort(clips, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        int start = clips[0][0];
        int end = clips[0][1];
        if (start != 0) {
            return -1;
        }
        int index = 1;
        while (index < clips.length && end < T) {
            int max = 0;
            while (index < clips.length && clips[index][0] <= end) {
                max = Math.max(max,clips[index][1]);
                index++;
            }
            if (end >= max) {
                break;
            }
            cnt++;
            end = max;
        }
        return end >= T ? cnt : -1;
    }
     */
}
