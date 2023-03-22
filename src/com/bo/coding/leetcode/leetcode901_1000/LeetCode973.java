package com.bo.coding.leetcode.leetcode901_1000;

import com.bo.coding.annotation.Question;

import java.util.Arrays;
import java.util.Comparator;

@Question
public class LeetCode973 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(point -> (point[0] * point[0] + point[1] * point[1])));
        return Arrays.copyOfRange(points, 0, K);
    }
}
