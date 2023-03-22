package com.bo.coding.competition.week211;

import java.util.*;

public class B {
    public String findLexSmallestString(String s, int a, int b) {
        Set<Integer> dir = new HashSet<>();
        int temp = a;
        for (int i = 0; i < 10; i++) {
            dir.add(a % 10);
            a += temp;
        }
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        if (b % 2 == 0) {
            for (Integer integer : dir) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < chars.length; i+=2) {
                    int num = chars[i] - '0';
                    sb.append((num + integer) % 10);
                }
                String str = sb.toString();
                for (int i = 0; i < str.length(); i++) {
                    int j = i;
                    int deep = 0;
                    sb = new StringBuilder();
                    while (deep++ < str.length()) {
                        sb.append(str.charAt(j));
                        j = (j + 1) % str.length();
                    }
                    list.add(sb.toString());
                }
            }
            list.sort(Comparator.naturalOrder());
            return list.get(0);
        } else {
            for (Integer integer : dir) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < chars.length; i+=2) {
                    int num = chars[i] - '0';
                    sb.append((num + integer) % 10);
                }
                String str = sb.toString();
                for (int i = 0; i < str.length(); i++) {
                    int j = i;
                    int deep = 0;
                    sb = new StringBuilder();
                    while (deep++ < str.length()) {
                        sb.append(str.charAt(j));
                        j = (j + 1) % str.length();
                    }
                    list.add(sb.toString());
                }
            }
            list.sort(Comparator.naturalOrder());
            String s1 = list.get(0);
            String s2;
            list = new ArrayList<> ();
            for (Integer integer : dir) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < chars.length; i+=2) {
                    int num = chars[i] - '0';
                    sb.append((num + integer) % 10);
                }
                String str = sb.toString();
                for (int i = 0; i < str.length(); i++) {
                    int j = i;
                    int deep = 0;
                    sb = new StringBuilder();
                    while (deep++ < str.length()) {
                        sb.append(str.charAt(j));
                        j = (j + 1) % str.length();
                    }
                    list.add(sb.toString());
                }
            }
            list.sort(Comparator.naturalOrder());
            s2 = list.get(0);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s1.length(); i++) {
                sb.append(s2.charAt(i));
                sb.append(s1.charAt(i));
            }
            return sb.toString();
        }
    }
}
