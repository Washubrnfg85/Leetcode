package com.leetcode;

public class Lc3_LongestSubstringNoRepeat {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        String substring = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            int j = i + 1;
            StringBuilder builder = new StringBuilder();
            builder.append(s.charAt(i));
            while (builder.indexOf(String.valueOf(s.charAt(j))) < 0) {
                builder.append(s.charAt(j));
                if (j < s.length() - 1) {
                    j++;
                } else {
                    break;
                }
            }
            if (builder.length() > substring.length())
                substring = builder.toString();
        }
        System.out.println(substring);

        return substring.length();
    }
}
