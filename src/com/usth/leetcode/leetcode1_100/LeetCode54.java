package com.usth.leetcode.leetcode1_100;

import com.usth.annotation.FinalEnd;

import java.util.ArrayList;
import java.util.List;

@FinalEnd
public class LeetCode54 {
    private int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    private int[][] vis;
    private List<Integer> list;
    public List<Integer> spiralOrder(int[][] matrix) {
        list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        vis = new int[matrix.length][matrix[0].length];
        dfs(matrix,0,0,0);
        return list;
    }

    private void dfs(int[][] map, int x, int y, int d) {
        list.add(map[x][y]);
        vis[x][y] = 1;
        if (list.size() == map.length * map[0].length) {
            return;
        }
        int nx = x + dir[d][0];
        int ny = y + dir[d][1];
        if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && vis[nx][ny] == 0) {
            dfs(map,nx,ny,d);
        } else {
            d = (d + 1) % 4;
            nx = x + dir[d][0];
            ny = y + dir[d][1];
            dfs(map,nx,ny,d);
        }
    }
}
