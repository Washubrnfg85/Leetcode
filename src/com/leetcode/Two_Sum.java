package com.leetcode;

import java.util.Arrays;

public class Two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length / 2 + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
