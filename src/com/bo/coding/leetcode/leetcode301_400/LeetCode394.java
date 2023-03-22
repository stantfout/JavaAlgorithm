package com.bo.coding.leetcode.leetcode301_400;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

import java.util.Deque;
import java.util.LinkedList;

@GoodQuestion
@Question(type = {TypeConst.DATA_STRUCTURE, TypeConst.RECURSION}, status = StatusEnum.FINAL_END)
public class LeetCode394 {

    //栈模拟
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> strStack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                strStack.addLast(res.toString());
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                Integer num = numStack.pollLast();
                while (num -- != 0) {
                    temp.append(res);
                }
                res = new StringBuilder(strStack.pollLast() + temp);
            } else if (isNum(c)) {
                int begin = i;
                while (isNum(s.charAt(i + 1))) {
                    i++;
                }
                numStack.addLast(Integer.valueOf(s.substring(begin, i + 1)));
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    private boolean isNum(char c) {
        return c >= '0' && c <='9';
    }

    /*递归
    public String decodeString(String s) {
        return getString(s, 1, 0).getValue();
    }

    private Pair<Integer,String> getString(String s, int num, int start) {
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = start; i < s.length(); i++) {
            //如果是数字，则获得数字和后面字符串对应编码的解码字符串，加入StringBuilder中
            if (isNum(s.charAt(i))) {
                //获取数字
                int begin = i;
                while (isNum(s.charAt(i))) {
                    i++;
                }
                //递归得到对应的解码字符串
                Pair<Integer, String> pair = getString(s, Integer.valueOf(s.substring(begin, i)), i + 1);
                //更新i的值
                i = pair.getKey();
                //加入当前加入StringBuilder中
                sb.append(pair.getValue());
            } else {
                //碰到']‘即可退出当前递归了
                if (s.charAt(i) == ']') {
                    break;
                }
                sb.append(s.charAt(i));
            }
        }
        //最后处理一下返回结果就可以返回了
        String temp = sb.toString();
        while (num > 1) {
            sb.append(temp);
            num--;
        }
        return new Pair<>(i,sb.toString());
    }

    private boolean isNum(char c) {
        return c >= '0' && c <='9';
    }
     */
}
