package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.Undone;

@Undone
public class LeetCode165 {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int i1 = 0;
        int i2 = 0;
        while (i1 < split1.length || i2 < split2.length) {
            int v1 = i1 < split1.length ? Integer.parseInt(split1[i1]) : 0;
            int v2 = i2 < split2.length ? Integer.parseInt(split2[i2]) : 0;
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
            i1++;
            i2++;
        }
        return 0;
    }
}
