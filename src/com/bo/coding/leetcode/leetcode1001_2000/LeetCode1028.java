package com.bo.coding.leetcode.leetcode1001_2000;

import com.bo.coding.annotation.GoodQuestion;
import com.bo.coding.annotation.Question;
import com.bo.coding.base.TreeNode;
import com.bo.coding.consts.TypeConst;

@GoodQuestion
@Question(type = {TypeConst.SIMULATION})
public class LeetCode1028 {
    private int i = 0;
    public TreeNode recoverFromPreorder(String S) {
        if (S.length() == 0) {
            return null;
        }
        int val = 0;
        while (i < S.length() && Character.isDigit(S.charAt(i))) {
            val = val * 10 + S.charAt(i++) - '0';
        }
        return buildTree(new TreeNode(val),1,S);
    }

    private TreeNode buildTree(TreeNode root, int deep, String str) {

        if (str.length() == i) {
            return root;
        }
        int len = 0;
        while (!Character.isDigit(str.charAt(i))) {
            i++;
            len++;
        }
        if (deep > len) {
            i -= len;
            return root;
        }
        int val = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            val = val * 10 + str.charAt(i++) - '0';
        }
        root.left = buildTree(new TreeNode(val),deep + 1, str);

        if (str.length() == i) {
            return root;
        }
        len = 0;
        while (!Character.isDigit(str.charAt(i))) {
            i++;
            len++;
        }
        if (deep > len) {
            i -= len;
            return root;
        }
        val = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            val = val * 10 + str.charAt(i++) - '0';
        }
        root.right = buildTree(new TreeNode(val),deep + 1, str);

        return root;
    }
}
