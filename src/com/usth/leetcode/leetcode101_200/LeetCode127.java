package com.usth.leetcode.leetcode101_200;
import com.usth.annotation.FinalEnd;
import com.usth.annotation.GoodQuestion;
import javafx.util.Pair;

import java.util.*;

@FinalEnd
@GoodQuestion("数据结构+搜索")
public class LeetCode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> table = new HashMap<>();
        init(beginWord, wordList, table);
        Set<String> vis = new HashSet<> ();

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord,1));

        while (!queue.isEmpty()) {
            Pair<String, Integer> top = queue.poll();
            String str = top.getKey();
            vis.add(str);
            Integer value = top.getValue();
            for (int i = 0; i < str.length(); ++i) {
                String newStr = str.substring(0,i) + '*' + str.substring(i + 1);
                List<String> list = table.get(newStr);
                for (String next : list) {
                    if (next.equals(endWord)) {
                        return value + 1;
                    }
                    if (!vis.contains(next)) {
                        queue.add(new Pair<>(next, value + 1));
                    }
                }
            }
        }
        return 0;
    }

    private void init(String beginWord, List<String> wordList, Map<String,List<String>> table) {
        for (int i = -1; i < wordList.size(); i++) {
            String str;
            if (i != -1) {
                str = wordList.get(i);
            } else {
                str = beginWord;
            }
            for (int j = 0; j < str.length(); j++) {
                String newStr = str.substring(0,j) + '*' + str.substring(j + 1);
                List<String> list = table.getOrDefault(newStr, new ArrayList<>());
                list.add(str);
                table.put(newStr, list);
            }
        }
    }
}
