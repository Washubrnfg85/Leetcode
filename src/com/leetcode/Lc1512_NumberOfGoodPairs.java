package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Lc1512_NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int value = map.get(nums[i]);
                map.replace(nums[i], ++value);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value > 1) {
                result += (value * (value - 1)) / 2;
            }
        }

        return result;
    }
}
