package com.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Lc1528_ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] letters = s.toCharArray();
        Map<Integer, Character> map = new TreeMap<>();

        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], letters[i]);
        }
        Object[] shuffledLetters = map.values().toArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shuffledLetters.length; i++) {
            sb.append(shuffledLetters[i]);
        }

        return sb.toString();
    }
}
