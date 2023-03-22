package com.bo.coding.leetcode.leetcode701_800;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;

import java.util.ArrayList;
import java.util.List;

@GoodQuestion
@Question(type = {TypeConst.GREEDY_ALGORITHM})
public class LeetCode763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a'] = i;
        }
        int i = 0;
        int pre = -1;
        int j = hash[S.charAt(0) - 'a'];
        while (i < S.length()) {
           if (hash[S.charAt(i) - 'a'] <= j) {
               i++;
           } else {
               j = hash[S.charAt(i) - 'a'];
           }
           if (i > j) {
               res.add(j - pre);
               pre = j;
               if (i < S.length()) {
                   j = hash[S.charAt(i) - 'a'];
               }
           }
        }
        return res;
    }
}
