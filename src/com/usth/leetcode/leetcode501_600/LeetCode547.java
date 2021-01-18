package com.usth.leetcode.leetcode501_600;

import com.usth.annotation.GoodQuestion;
import com.usth.annotation.Undone;

import java.util.LinkedList;
import java.util.Queue;

@Undone
@GoodQuestion("(DFS/BFS/并查集).入门")
public class LeetCode547 {

    // BFS
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int temp = queue.poll();
                    visited[temp] = true;
                    for (int j = 0; j < n; j++) {
                        if (isConnected[temp][j] == 1 && !visited[j]) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    /* DFS
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited, n);
                count++;
            }
        }
        return count;
    }

    private void dfs(int start, int[][] isConnected, boolean[] visited, int n) {
        visited[start] = true;
        for (int i = 0; i < n; i++) {
            if (isConnected[start][i] == 1 && !visited[i]) {
                dfs(i, isConnected, visited, n);
            }
        }
    }
     */

    /* 并查集
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j, parents);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (find(i, parents) == parents[i]) {
                count++;
            }
        }
        return count;
    }

    private void union(int x, int y, int[] parents) {
        int fx = find(x, parents);
        int fy = find(y, parents);
        if (fx != fy) {
            parents[fx] = fy;
        }
    }

    private int find(int x, int[] parents) {
        if (parents[x] == x) {
            return parents[x];
        }
        return parents[x] = find(parents[x], parents);
    }
     */
}
