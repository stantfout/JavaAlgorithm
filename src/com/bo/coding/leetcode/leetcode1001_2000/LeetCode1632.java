package com.bo.coding.leetcode.leetcode1001_2000;

import com.bo.coding.annotation.Question;
import com.bo.coding.consts.StatusEnum;
import com.bo.coding.consts.TypeConst;

@Question(type = {TypeConst.DISJOINT_SET_DATA_STRUCTURE}, status = StatusEnum.UNDONE)
public class LeetCode1632 {
    private int m = 0;
    private int n = 0;
    public int[][] matrixRankTransform(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (answer[i][j] == 0) {
                    findMinValue(matrix, answer, matrix[i][j], i, j);
                }
            }
        }

        return answer;
    }

    private int findMinValue(int[][] matrix, int[][] answer, int now, int i, int j) {
        int min = Integer.MIN_VALUE;
        int mi = i;
        int mj = j;
        int value = 0;

        for (int fj = 0; fj < n; fj++) {
            if (answer[i][fj] == 0) {
                if (matrix[i][fj] < now && matrix[i][fj] > min) {
                    min = matrix[i][fj];
                    mi = i;
                    mj = fj;
                } else if (matrix[i][fj] == now && fj > j) {
                    value = findMinValue(matrix, answer, now, i, fj) - 1;
                }
            } else {
                if (matrix[i][fj] < now)
                    value = Math.max(value, answer[i][fj]);
                else if (matrix[i][fj] == now) {
                    answer[i][j] = answer[i][fj];
                    return answer[i][fj];
                }
            }
        }

        for (int fi = 0; fi < m; fi++) {
            if (answer[fi][j] == 0) {
                if (matrix[fi][j] < now && matrix[fi][j] > min) {
                    min = matrix[fi][j];
                    mi = fi;
                    mj = j;
                } else if (matrix[fi][j] == now && fi > i) {
                    value = findMinValue(matrix, answer, now, fi, j) - 1;
                }
            } else {
                if (matrix[fi][j] < now)
                    value = Math.max(value, answer[fi][j]);
                else if (matrix[fi][j] == now) {
                    answer[i][j] = answer[fi][j];
                    return answer[fi][j];
                }
            }
        }

        if (i == mi && j == mj) {
            answer[i][j] = value + 1;
            return value + 1;
        }
        
        int preValue = findMinValue(matrix, answer, min, mi, mj);
        int finalValue = Math.max(value, preValue) + 1;
        answer[i][j] = finalValue;
        return finalValue;
    }

    public static void main(String[] args) {
        LeetCode1632 lt = new LeetCode1632();
        int[][] matrix = new int[][]{
            {-37,-50,-3,44},
            {-37,46,13,-32},
            {47,-42,-3,-40},
            {-17,-22,-39,24}
        };
        /*
         * [
         * [2,1,4,6],
         * [2,6,5,4],
         * [5,2,4,3],
         * [4,3,1,5]
         * ]
         * ---------
         * [
         * [2,1,3,6],
         * [2,5,4,4],
         * [5,2,3,3],
         * [4,3,1,5]
         * ]
         */
        lt.matrixRankTransform(matrix);
    }
}
