package com.leetcode;

public class Lc704_BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle = nums.length / 2;

        while (left <= right) {
            if(target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = left + ((right - left) / 2);
        }
        return -1;
    }
}