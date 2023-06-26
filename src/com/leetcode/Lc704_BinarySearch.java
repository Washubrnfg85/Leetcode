package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Lc704_BinarySearch {
    public int search(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return list.indexOf(target);
    }
}
