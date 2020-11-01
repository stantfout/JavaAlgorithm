package com.usth.leetcode.leetcodemore;

import com.usth.annotation.Undone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Undone
public class LeetCode1002 {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] hash = new int[26];
        Arrays.fill(hash, 101);
        for (String s : A) {
            int[] temp = new int[26];
            for (int i = 0; i < s.length(); i++) {
                temp[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                hash[i] = Math.min(hash[i], temp[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (hash[i]-- != 0) {
                char c = (char) ('a' + i);
                res.add(String.valueOf(c));
            }
        }
        return res;
    }
}
