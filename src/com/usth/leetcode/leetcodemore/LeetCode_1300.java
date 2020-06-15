package com.usth.leetcode.leetcodemore;

public class LeetCode_1300 {
    public int findBestValue(int[] arr, int target) {

        int left = 0;
        int right = 0;
        /**
         * 这里要遍历找出最大值，不能用一个大数代替，因为二分只能找出第一个大于等于或者最后一个小于等于的情况，
         * 而题目要求是最接近的情况，如果数组和小于target，二分搜索的结果可能会为right
         * 所以right不能为一个较大的数，而一定要是准确的数组最大值
         */
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
        }
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (judge(mid, arr) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //要找出最接近的情况，此时上面二分搜索的left为第一个大于的情况，right为第一个小于等于的情况，所以要比较一下哪个最接近
        if (Math.abs(judge(left, arr) - target) >= Math.abs(judge(right, arr) - target)) {
            return right;
        } else {
            return left;
        }
    }

    private int judge(int value, int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value) {
                sum += value;
            } else {
                sum += arr[i];
            }
        }
        return sum;
    }
}
