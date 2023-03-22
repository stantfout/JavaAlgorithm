package com.bo.coding.leetcode.leetcode601_700;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;

import java.util.Arrays;

@GoodQuestion
@Question(type = {TypeConst.SIMULATION})
public class LeetCode649 {
    public String predictPartyVictory(String senate) {
        //DDR
        //DRRDR
        boolean[] hasPower = new boolean[senate.length()];
        Arrays.fill(hasPower, true);
        int sumRadiant = 0;
        int sumDire = 0;
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'D') {
                sumDire++;
            } else {
                sumRadiant++;
            }
        }
        int radiant = 0;
        int dire = 0;
        while (sumRadiant != 0 && sumDire != 0) {
            for (int i = 0; i < senate.length(); i++) {
                char c = senate.charAt(i);
                if (hasPower[i]) {
                    if (c == 'D') {
                        if (radiant == 0) {
                            dire++;
                        } else {
                            radiant--;
                            sumDire--;
                            hasPower[i] = false;
                        }
                    } else {
                        if (dire == 0) {
                            radiant++;
                        } else {
                            dire--;
                            sumRadiant--;
                            hasPower[i] = false;
                        }
                    }
                }
            }
        }
        return sumRadiant == 0 ? "Dire" : "Radiant";
    }
}
