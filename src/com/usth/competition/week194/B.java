package com.usth.competition.week194;

import java.util.HashMap;
import java.util.Map;

public class B {
    public String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; ++i) {
            String name = names[i];
            if (map.containsKey(name)) {
                Integer integer = map.get(name);
                String temp = name + "(" + integer + ")";
                while (map.containsKey(temp)) {
                    integer += 1;
                    temp = name + "(" + integer + ")";
                }
                res[i] = temp;
                map.put(name,integer + 1);
                map.put(res[i],1);
            } else {
                res[i] = name;
                map.put(name,1);
            }
        }
        return res;
    }
}
