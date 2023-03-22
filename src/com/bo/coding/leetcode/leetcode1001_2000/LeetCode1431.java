package com.bo.coding.leetcode.leetcode1001_2000;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

import	java.util.ArrayList;

import java.util.List;

@Question(type = {TypeConst.SIMPLE_QUESTION}, status = StatusEnum.FINAL_END)
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
