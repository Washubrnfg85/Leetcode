package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Lc14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();

        Arrays.sort(strs);

        for (int i = 0; i < strs[0].length(); i++) {
            char theLetter = strs[0].charAt(i);
            int matchCounter = 0;

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) == theLetter) {
                    matchCounter++;
                } else {
                    return commonPrefix.toString();
                }
            }
            if (matchCounter == strs.length - 1) {
                commonPrefix.append(theLetter);
            }

        }

        return commonPrefix.toString();
    }
}
