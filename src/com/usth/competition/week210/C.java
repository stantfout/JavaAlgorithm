package com.usth.competition.week210;

public class C {
    public boolean checkPalindromeFormation(String a, String b) {
        if (judge(a) || judge(b)) {
            return true;
        }
        return a.charAt(0) == b.charAt(b.length() - 1) || (a.charAt(a.length() - 1) == b.charAt(0));
    }

    private boolean judge(String str) {
        int i = 0;
        int j = str.length();
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
