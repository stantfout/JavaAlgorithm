package com.bo.coding.leetcode.leetcode1_100;

import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@Question(type = {TypeConst.SIMULATION}, status = StatusEnum.FINAL_END)
public class LeetCode67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int cnt = flag;
            if (i >= 0) {
                cnt += a.charAt(i) == '1' ? 1 : 0;
                i--;
            }
            if (j >= 0) {
                cnt += b.charAt(j) == '1' ? 1 : 0;
                j--;
            }
            sb.append(cnt % 2);
            flag = cnt / 2;
        }
        if (flag != 0) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }
}
