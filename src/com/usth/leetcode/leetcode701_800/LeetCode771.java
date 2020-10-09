package com.usth.leetcode.leetcode701_800;

import com.usth.annotation.Undone;

import java.util.HashSet;
import java.util.Set;

@Undone
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
