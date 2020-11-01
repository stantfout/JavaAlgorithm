package com.usth.leetcode.leetcodemore;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;

@Undone
@GoodQuestion("暴力模拟,代码能力")
public class LeetCode1625 {
    public String findLexSmallestString(String s, int a, int b) {
        char[] arr = s.toCharArray();
        return new String(solve(arr, a, b));
    }

    private char[] solve(char[] arr, int a, int b) {
        int n = arr.length;
        char[] minArr = arr;
        if ((b & 1) == 1) {
            for (int i = 1; i <= 10; i++) {
                addVal(arr, 0, a);
                for (int j = 1; j <= 10; j++) {
                    addVal(arr, 1, a);
                    for (int k = 0; k < n; k++) {
                        arr = rotate(arr, b);
                        getMinArr(arr, minArr);
                    }
                }
            }
        } else {
            for (int i = 1; i <= 10; i++) {
                addVal(arr, 1, a);
                for (int j = 0; j < n; j++) {
                    arr = rotate(arr, b);
                    getMinArr(arr, minArr);
                }
            }
        }
        return minArr;
    }

    private void getMinArr(char[] arr, char[] minArr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] != minArr[i]) {
                if (arr[i] < minArr[i]) {
                    for (int j = 0; j < n; j++) {
                        minArr[j] = arr[j];
                    }
                }
                return;
            }
        }
    }

    private char[] rotate(char[] arr, int step) {
        int n = arr.length;
        char[] temp = new char[n];
        int index = 0;
        for (int i = step; index < n; i++) {
            temp[index++] = arr[i % n];
        }
        return temp;
    }

    private void addVal(char[] arr, int start, int val) {
        for (int i = start; i < arr.length; i += 2) {
            arr[i] = (char) ('0' + ((arr[i] - '0' + val) % 10));
        }
    }
}
