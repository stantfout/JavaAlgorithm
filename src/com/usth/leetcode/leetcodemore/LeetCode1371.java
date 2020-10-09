package com.usth.leetcode.leetcodemore;

import com.usth.annotation.FinalEnd;

import java.util.Arrays;

@FinalEnd
public class LeetCode1371 {
    public int findTheLongestSubstring(String s) {
        //建立一个Hash表，Hash表存储的是某种状态第一次出现的位置。
        int[] hash = new int[1 << 5];
        //先初始化为-2(-2这里表示的是第一次出现的位置还没确定)
        Arrays.fill(hash, -2);
        //要返回的最大值
        int max = 0;
        //元音字母出现的状态
        int status = 0;
        //状态0出现的第一个位置是-1
        hash[0] = -1;
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //这里判断c对应的字符，更新状态
            switch (c) {
                case 'a' : status ^= 1; break;
                case 'e' : status ^= (1 << 1); break;
                case 'i' : status ^= (1 << 2); break;
                case 'o' : status ^= (1 << 3); break;
                case 'u' : status ^= (1 << 4); break;
            }
            if (hash[status] == -2) {
                //如果该状态第一次出现的位置还没确定，就更新为这个位置
                hash[status] = i;
            } else {
                //如果确定了，就计算值。
                max = Math.max(max, i - hash[status]);
            }
        }
        //返回结果
        return max;
    }
}
