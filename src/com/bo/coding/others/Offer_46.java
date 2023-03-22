package com.bo.coding.others;

public class Offer_46 {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        if (numStr.length() <= 1) {
            return 1;
        }
        int[] dp = new int[numStr.length()];
        dp[0] = 1;
        dp[1] = judge(numStr.charAt(0),numStr.charAt(1)) ? 2 : 1;
        for (int i = 2; i < numStr.length(); ++i) {
            if (judge(numStr.charAt(i - 1), numStr.charAt(i))) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[numStr.length() - 1];
    }

    private boolean judge(char pre, char now) {
        if (pre == '1') {
            return true;
        } else if (pre == '2') {
            return now >= '0' && now <= '5';
        } else {
            return false;
        }
    }
}
