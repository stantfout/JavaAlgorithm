package com.usth.leetcode.leetcodemore;
import com.usth.annotation.FinalEnd;

import	java.util.ArrayList;

import java.util.List;

@FinalEnd
public class LeetCode1431 {
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
