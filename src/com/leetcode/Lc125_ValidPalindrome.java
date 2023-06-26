package com.leetcode;

public class Lc125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        String result = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        char[] chars = result.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        if (result.equals(sb.toString())) return true;
        return false;
    }
}
