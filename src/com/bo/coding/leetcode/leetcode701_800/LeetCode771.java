package com.bo.coding.leetcode.leetcode701_800;

import com.bo.coding.annotation.Question;

import java.util.HashSet;
import java.util.Set;

@Question
public class LeetCode771 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
