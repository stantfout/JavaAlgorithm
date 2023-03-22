package com.bo.coding.leetcode.leetcode201_300;

import com.bo.coding.annotation.Question;

import java.util.HashMap;
import java.util.Map;

@Question
public class LeetCode205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sTot = new HashMap<>();
        Map<Character, Character> tTos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sTot.containsKey(s.charAt(i))) {
                Character temp = sTot.get(s.charAt(i));
                if (temp != t.charAt(i)) {
                    return false;
                }
            } else {
                if (tTos.containsKey(t.charAt(i))) {
                    return false;
                } else {
                    sTot.put(s.charAt(i), t.charAt(i));
                    tTos.put(t.charAt(i), s.charAt(i));
                }
            }
        }
        return true;
    }
}
