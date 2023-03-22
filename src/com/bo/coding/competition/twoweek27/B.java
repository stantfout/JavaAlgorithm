package com.bo.coding.competition.twoweek27;

import java.util.HashSet;
import java.util.Set;

public class B {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i,i + k));
        }
        return set.size() == Math.pow(2,k);
    }
}
