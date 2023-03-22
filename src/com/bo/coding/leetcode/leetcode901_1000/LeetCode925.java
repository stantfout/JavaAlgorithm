package com.bo.coding.leetcode.leetcode901_1000;

import com.bo.coding.annotation.Question;

@Question
public class LeetCode925 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while (i < name.length() || j < typed.length()) {
            if (i < name.length() && j < typed.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                if (i != 0 && j < typed.length() && typed.charAt(j - 1) == typed.charAt(j)) {
                    j++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
