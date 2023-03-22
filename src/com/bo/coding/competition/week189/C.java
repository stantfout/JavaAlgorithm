package com.bo.coding.competition.week189;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        int n = favoriteCompanies.size();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (!judge(favoriteCompanies.get(i), favoriteCompanies.get(j))) {
                    flag = false;
                }
            }
            if (flag) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean judge(List<String> listA, List<String> listB) {
        if (listA.size() > listB.size()) {
            return true;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < listB.size(); i++) {
            set.add(listB.get(i));
        }
        for (int i = 0; i < listA.size(); i++) {
            if (!set.contains(listA.get(i))) {
                return true;
            }
        }
        return false;
    }
}
