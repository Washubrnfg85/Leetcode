package com.leetcode;

public class Lc27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) break;
            if (nums[i] == val) {
                swap(nums, i);
                i--;
            } else {
                counter++;
            }
        }

        return counter;
    }

    private void swap(int[] array, int i) {
        for (int j = i; j < array.length; j++) {
            if (j < array.length - 1) {
                array[j] = array[j + 1];
            }
        }
        array[array.length - 1] = -1;
    }
}
