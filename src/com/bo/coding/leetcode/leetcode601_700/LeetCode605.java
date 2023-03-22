package com.bo.coding.leetcode.leetcode601_700;

import com.bo.coding.annotation.Question;

@Question
public class LeetCode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int sum = 0;
        int index = 0;
        while (index < flowerbed.length) {
            if (flowerbed[index] == 1) {
                sum += count / 2;
                count = 0;
                index++;
            } else {
                count++;
            }
            index++;
        }
        sum += (count + 1) / 2;
        return sum >= n;
    }
}
