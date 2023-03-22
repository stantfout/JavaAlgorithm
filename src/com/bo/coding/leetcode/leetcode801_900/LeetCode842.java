package com.bo.coding.leetcode.leetcode801_900;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;

import java.util.ArrayList;
import java.util.List;

@GoodQuestion
@Question(type = {TypeConst.RECURSION})
public class LeetCode842 {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        solve(S, list, 0, 0 ,0);
        return list;
    }

    private boolean solve(String str, List<Integer> list, int index, int sum, int pre) {
        if (index == str.length()) {
            return list.size() >= 3;
        }
        long nowLong = 0;
        for (int i = index; i < str.length(); i++) {
            if (i > index && str.charAt(index) == '0') {
                break;
            }
            nowLong = nowLong * 10 + str.charAt(i) - '0';
            if (nowLong > Integer.MAX_VALUE) {
                break;
            }
            int now = (int) nowLong;
            if (list.size() >= 2) {
                if (now < sum) {
                    continue;
                } else if (now > sum) {
                    break;
                }
            }
            list.add(now);
            if (solve(str,list,i + 1,pre + now, now)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

}
