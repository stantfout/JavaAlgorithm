package com.usth.leetcode.leetcode101_200;

import com.usth.annotation.FinalEnd;
import com.usth.annotation.GoodQuestion;

import	java.util.LinkedList;
import java.util.*;

@FinalEnd
@GoodQuestion("数据结构+搜索")
public class LeetCode126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return res;
        }

        Map<String, List<String>> table = new HashMap<>();
        init(beginWord, wordList, table);
        Set<String> vis = new HashSet<>();

        Queue<List<String>> queue = new LinkedList<> ();
        ArrayList<String> begin = new ArrayList<> ();
        begin.add(beginWord);
        queue.add(begin);

        boolean isEnd = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                List<String> top = queue.poll();
                String str = top.get(top.size() - 1);
                vis.add(str);
                for (int i = 0; i < str.length(); ++i) {
                    String newStr = str.substring(0,i) + '*' + str.substring(i + 1);
                    List<String> list = table.get(newStr);
                    for (String next : list) {
                        if (!vis.contains(next)) {
                            ArrayList<String> temp = new ArrayList<>(top);
                            temp.add(next);
                            if (next.equals(endWord)) {
                                res.add(temp);
                                isEnd = true;
                            }
                            queue.add(temp);
                        }
                    }
                }
            }
            if (isEnd) {
                return res;
            }
        }

        return res;
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
