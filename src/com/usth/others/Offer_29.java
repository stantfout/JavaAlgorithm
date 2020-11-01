package com.usth.others;

public class Offer_29 {

    private int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    private int[] res;
    private boolean[][] vis;
    private int n;
    private int m;
    private int i = 0;

    public int[] spiralOrder(int[][] matrix) {
        n = matrix.length;
        if (n == 0) {
            return new int[0];
        }
        m = matrix[0].length;
        res = new int[n * m];
        vis = new boolean[n][m];
        dfs(matrix,0,0,0);
        return res;
    }

    private void dfs(int[][] map,int x, int y, int d) {
        if (i == n * m) {
            return;
        }
        if (!vis[x][y]) {
            res[i++] = map[x][y];
        }
        vis[x][y] = true;
        int nx = x + dir[d][0];
        int ny = y + dir[d][1];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
            dfs(map,nx,ny,d);
        } else {
            dfs(map,x,y,(d + 1) % 4);
        }
    }

}
