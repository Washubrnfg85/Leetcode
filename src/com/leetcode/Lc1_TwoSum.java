package com.leetcode;

public class Lc1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length / 2 + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
