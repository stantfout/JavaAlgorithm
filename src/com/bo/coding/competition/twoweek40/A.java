package com.bo.coding.competition.twoweek40;

public class A {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        int j = 0;
        int max = 0;
        for (int i = 0; i < sequence.length();) {
            if (sequence.charAt(i) == word.charAt(j)) {
                i++;
                j++;
                if (j == word.length()) {
                    j = 0;
                    count++;
                }
            } else {
                i = i - j + 1;
                j = 0;
                max = Math.max(max, count);
                count = 0;
            }
        }
        return max;
    }
}
