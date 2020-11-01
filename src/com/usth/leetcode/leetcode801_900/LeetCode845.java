package com.usth.leetcode.leetcode801_900;

import com.usth.annotation.Undone;

@Undone
public class LeetCode845 {
    public int longestMountain(int[] A) {
        int res = 0;
        int left = 0;
        int mid = left;
        while (mid < A.length - 1) {
            mid = left;
            while (mid < A.length - 1 && A[mid + 1] > A[mid]) {
                mid++;
            }
            if (left >= mid) {
                left++;
                continue;
            }
            int right = mid;
            while (right < A.length - 1 && A[right] > A[right + 1]) {
                right++;
            }
            if (right > mid) {
                res = Math.max(res, right - left + 1);
            }
            left = right;
        }
        return res;
    }
}
