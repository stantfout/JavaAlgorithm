package com.bo.coding.leetcode.leetcode1001_2000;

import com.bo.coding.consts.TypeConst;
import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;

@GoodQuestion
@Question(type = {TypeConst.GREEDY_ALGORITHM})
public class LeetCode1662 {

    public String getSmallestString(int n, int k) {
        StringBuilder builder = new StringBuilder();
        
        k -= n;
        int up = k % 25;
        int index = n - (k / 25);

        for (int i = 1; i <= n; i++) {
            if (i < index) 
                builder.append('a');
            else if (i == index)
                builder.append((char)('a' + up));
            else 
                builder.append('z');
        }

        return builder.toString();
    }
}
