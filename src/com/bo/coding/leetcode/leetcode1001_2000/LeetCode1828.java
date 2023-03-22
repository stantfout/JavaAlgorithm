package com.bo.coding.leetcode.leetcode1001_2000;

import com.bo.coding.annotation.Question;
import com.bo.coding.consts.TypeConst;

@Question(type = {TypeConst.ENUMERATE})
public class LeetCode1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int m = points.length;
        int n = queries.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            int qx = queries[i][0];
            int qy = queries[i][1];
            int r = queries[i][2];
            int count = 0;
            for (int j = 0; j < m; j++) {
                int px = points[j][0];
                int py = points[j][1];
                if (isAllowDistance(qx,qy,r,px,py)) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }

    private boolean isAllowDistance(int qx, int qy, int r, int px, int py) {
        int dis = (px - qx)*(px - qx) + (py - qy) * (py - qy);
        if (dis <= r * r)
            return true;
        return false;
    }
}
