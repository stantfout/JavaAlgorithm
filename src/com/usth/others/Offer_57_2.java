package com.usth.others;

import java.util.ArrayList;
import java.util.List;

public class Offer_57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1;
        int right = 1;
        int sum = 1;//滑动窗口[left,right]的和
        //当(left <= target / 2)时，就可以退出循环了，因为不存在满足条件的序列了
        while (left <= target / 2) {
            if (sum > target) {
                sum -= left;
                left++;
            } else if (sum < target) {
                right++;
                sum += right;
            } else {
                int[] temp = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    temp[i - left] = i;
                }
                res.add(temp);
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
