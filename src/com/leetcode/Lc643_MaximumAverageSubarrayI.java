package com.leetcode;

import java.util.Arrays;

public class Lc643_MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        if (k < 1 | k > nums.length) throw new IllegalArgumentException();
        if (nums.length == 1 & k == 1)  return ((double) nums[0]) / k;

        double maxAverageValue = 0.0;
        for (int i = 0; i < nums.length - k; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            System.out.println(sum);
            if (maxAverageValue < sum / k) {
                maxAverageValue = sum / k;
            }
        }

        return maxAverageValue;
    }
}
