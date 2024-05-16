package com.leetcode;

public class Lc58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");

        return words[words.length - 1].length();
    }
}
