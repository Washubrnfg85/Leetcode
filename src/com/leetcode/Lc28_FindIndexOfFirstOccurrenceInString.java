package com.leetcode;

public class Lc28_FindIndexOfFirstOccurrenceInString {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle))
            return 0;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i >= needle.length() && haystack.charAt(i) == (needle.charAt(0))) {
                if (needle.equals(haystack.substring(i, i + needle.length())))
                    return i;
            }
        }
        return -1;
    }
}
