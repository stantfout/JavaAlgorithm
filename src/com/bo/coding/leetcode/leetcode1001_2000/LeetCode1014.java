package com.bo.coding.leetcode.leetcode1001_2000;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.THINKING})
public class LeetCode1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int max = A[0] + 0;
        for (int i = 1; i < A.length; ++i) {
            res = Math.max(res, max + A[i] - i);
            max = Math.max(max, A[i] + i);
        }
        return res;
    }
}
