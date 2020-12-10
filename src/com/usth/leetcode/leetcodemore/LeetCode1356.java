package com.usth.leetcode.leetcodemore;

import com.usth.annotation.Undone;

import java.util.ArrayList;
import java.util.List;

@Undone
public class LeetCode1356 {
    public int[] sortByBits(int[] arr) {
        int[] bits = new int[arr.length];
        List<Integer> list = new ArrayList<>();
        for (int value : arr) {
            bits[value] = getBit(value);
            list.add(value);
        }
        list.sort((o1, o2) -> {
            if (bits[o1] != bits[o2]) {
                return bits[o1] - bits[o2];
            }
            return o1 - o2;
        });
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int getBit(int num) {
        int res = 0;
        while (num != 0) {
            num &= num - 1;
            res++;
        }
        return res;
    }
}
