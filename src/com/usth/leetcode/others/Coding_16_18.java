package com.usth.leetcode.others;

public class Coding_16_18 {
    public boolean patternMatching(String pattern, String value) {
        if (value.length() == 0) {
            int cnt = 0;
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == 'a') {
                    cnt |= 1;
                } else {
                    cnt |= 1 << 1;
                }
            }
            return cnt != 3;
        }
        if (pattern.length() == 0) {
            return false;
        }
        if (pattern.length() > value.length()) {
            return false;
        }
        int sumA = 0,sumB = 0;
        int n = value.length();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') {
                sumA++;
            } else {
                sumB++;
            }
        }
        if (sumA == 0 || sumB == 0) {
            int sum = sumA == 0 ? sumB : sumA;
            if (n % sum != 0) {
                return false;
            }
            int len = n / sum;
            String temp = value.substring(0,len);
            for (int i = 0; i < n; i += len) {
                if (!value.substring(i,i + len).equals(temp)) {
                    return false;
                }
            }
            return true;
        }
        for (int al = 0; al <= n / sumA; al++) {
            if ((n - sumA * al) % sumB != 0) {
                continue;
            }
            int bl = (n - sumA * al) / sumB;
            String a = null;
            String b = null;
            int i = 0;
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) == 'a') {
                    String temp = value.substring(i,i + al);
                    if (a == null) {
                        a = temp;
                    } else {
                        if (!a.equals(temp)) {
                            break;
                        }
                    }
                    i += al;
                } else {
                    String temp = value.substring(i,i + bl);
                    if (b == null) {
                        b = temp;
                    } else {
                        if (!b.equals(temp)) {
                            break;
                        }
                    }
                    i += bl;
                }
            }
            if (i == n) {
                return true;
            }
        }
        return false;
    }
}
