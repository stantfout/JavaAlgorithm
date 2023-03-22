package com.bo.coding.leetcode.leetcode2001_3000;

import java.util.HashMap;
import java.util.Map;

import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;

@Question(type = {TypeConst.HASH})
public class LeetCode2325 {
    public String decodeMessage(String key, String message) {
        char now = 'a';
        Map<Character, Character> rulers = new HashMap<>();
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (!rulers.containsKey(ch)) {
                rulers.put(ch, now);
                now = (char)(now + 1);
                if (now > 'z') 
                    break;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                builder.append(c);
            } else {
                builder.append(rulers.get(c));
            }
        }

        return builder.toString();
    }
}
