package com.bo.coding.leetcode.leetcode401_500;

import com.bo.coding.annotation.Question;

@Question
public class LeetCode463 {
    public int islandPerimeter(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    cnt += judge(grid,i, j);
                }
            }
        }
        return cnt;
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int judge(int[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 4;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                cnt--;
            }
        }
        return cnt;
    }

}
