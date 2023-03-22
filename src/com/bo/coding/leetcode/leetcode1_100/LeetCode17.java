package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;

import java.util.*;

@GoodQuestion
@Question(type = {TypeConst.RECURSION})
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        String str = "";

        buildResult(map,res,digits,0,str);

        return res;
    }

    private void buildResult(Map<Character, String> map, List<String> res, String digits, int index,String nowStr) {
        if (index == digits.length()) {
            res.add(nowStr);
            return;
        }
        char c = digits.charAt(index);
        String str = map.get(c);
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            buildResult(map,res,digits,index + 1,nowStr + temp);
        }
    }
}
