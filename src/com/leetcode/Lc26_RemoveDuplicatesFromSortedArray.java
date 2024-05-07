package com.leetcode;

public class Lc26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int counter = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1) {
                if (nums[i] < nums[i + 1]) {
                    counter++;
                } else if (nums[i] > nums[i + 1]) {
                    break;
                } else {
                    swap(nums, i);
                    i--;
                }
            } else {
                return counter;
            }
        }
        return counter;
    }

    private void swap(int[] array, int i) {
        for (int j = i + 1; j < array.length; j++) {
            if (j < array.length - 1) {
                array[j] = array[j + 1];
            }
        }
        array[array.length - 1] = -101;
    }
}
