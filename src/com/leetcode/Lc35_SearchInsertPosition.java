package com.leetcode;

import java.util.Arrays;

public class Lc35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);

        if (i < 0)
            i = i - (i * 2) - 1;

        return i;
    }
}
