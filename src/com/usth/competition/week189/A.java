package com.usth.competition.week189;

public class A {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                cnt++;
            }
        }
        return cnt;
    }
}
