package com.usth.leetcode.leetcodemore;
import	java.util.ArrayList;

import java.util.List;

public class LeetCode_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max,candies[i]);
        }
        List<Boolean> res = new ArrayList<> ();
        for (int i = 0; i < candies.length; i++) {
            if (extraCandies + candies[i] >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
