package com.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Lc1859_SortingTheSentence {
    public String sortSentence(String s) {
        String result = "";
        String[] words = s.split(" ");

        Map<Integer, String> sortedWords = new TreeMap<>();

        for (int i = 0; i < words.length; i++) {
            sortedWords.put(Integer.parseInt(words[i].substring(words[i].length() - 1)),
                                                    words[i].substring(0, words[i].length() - 1));
        }

        for (int i = 1; i <= sortedWords.size(); i++) {
            result += i < sortedWords.size() ? sortedWords.get(i) + " " : sortedWords.get(i);
        }

        return result;
    }
}
