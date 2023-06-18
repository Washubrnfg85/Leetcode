package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String result = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        if(result.length() <= 1) return false;
        char[] chars = result.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        if (result.equals(sb.toString())) return true;
        return false;
    }
}
