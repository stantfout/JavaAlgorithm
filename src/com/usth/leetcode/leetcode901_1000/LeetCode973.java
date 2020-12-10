package com.usth.leetcode.leetcode901_1000;

import com.usth.annotation.Undone;

import java.util.Arrays;
import java.util.Comparator;

@Undone
public class LeetCode973 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(point -> (point[0] * point[0] + point[1] * point[1])));
        return Arrays.copyOfRange(points, 0, K);
    }
}
