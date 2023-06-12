package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group_Anagrams {
    public static void main(String[] args) {
        String[] strs = new String[]{"ddddddddddg","dgggggggggg"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        for(int i = 0; i < strs.length; i++) {
            List<String> lettersOfWord = Arrays.asList(strs[i].split(""));
            List<String> listOfAnagrams = new ArrayList<>();

            for (int j = 0; j < strs.length; j++) {
                List<String> lettersOfOtherWord = Arrays.asList(strs[j].split(""));
                if (areAnagrams(lettersOfWord, lettersOfOtherWord) && !listOfAnagrams.contains(String.valueOf(lettersOfOtherWord))) {
                    listOfAnagrams.add(strs[j]);
                }
            }
            if (!containsListOfAnagrams(result, listOfAnagrams)) {
                result.add(listOfAnagrams);
            }
        }
        return result;
    }

    public static boolean areAnagrams(List<String> one, List<String> two) {
        if (one.size() == 1 || two.size() == 1) {
            return one.get(0).equals(two.get(0));
        }
        if (one.size() >= two.size()) {
            return one.containsAll(two);
        } else {
            return two.containsAll(one);
        }
    }

    public static boolean containsListOfAnagrams(List<List<String>> result, List<String> anagrams) {
        for(List<String> listOfAnagrams : result) {
            if (listOfAnagrams.containsAll(anagrams)) {
                return true;
            }
        }
        return false;
    }
}
