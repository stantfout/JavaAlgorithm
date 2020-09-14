package com.usth.competition.week200;

public class C {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int num = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] != 1) {
                    num++;
                } else {
                    break;
                }
            }
            nums[i] = num;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int need = n - i - 1;
            System.out.println("need = " + need + "\n" + "i = " + nums[i]);
            if (nums[i] < need) {
                int j = i + 1;
                while (j < n && nums[j] < need) {
                    j++;
                }
                if (j >= n) {
                    return -1;
                }
                count += j - i;
                while (j > i) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    j--;
                }
            }
        }
        return count;
    }
}
