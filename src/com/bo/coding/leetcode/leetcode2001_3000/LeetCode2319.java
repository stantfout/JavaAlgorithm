package com.bo.coding.leetcode.leetcode2001_3000;

import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;

@Question(type = {TypeConst.SIMPLE_QUESTION})
public class LeetCode2319 {
    public boolean checkXMatrix(int[][] grid) {
        int size = grid.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isDiagonal(i, j, size)) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isDiagonal(int x, int y, int size) {
        if (x == y || (x + y + 1) == size)
            return true;
        return false;
    }
}
