package com.bo.coding.leetcode.leetcode301_400;

import com.bo.coding.annotation.Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Question
public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer integer : set1) {
            if (set2.contains(integer)) {
                list.add(integer);
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (Integer integer : list) {
            res[index++] = integer;
        }
        return res;
    }
}
