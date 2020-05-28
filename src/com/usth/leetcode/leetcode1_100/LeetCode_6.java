package com.usth.leetcode.leetcode1_100;

public class LeetCode_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < numRows; i++) {
            if(i == 0 || i == numRows - 1) {
                int j = i;
                while (j < length) {
                    sb.append(s.charAt(j));
                    j += (2 * numRows  - 2);
                }
            } else {
                int j = i;
                int k = 1;
                while (j < length) {
                    sb.append(s.charAt(j));
                    if(k % 2 == 0) {
                        j += (2 * i);
                    } else {
                        j += (2 * numRows - 2 - 2 * i);
                    }
                    k++;
                }
            }
        }
        return sb.toString();
    }
}
