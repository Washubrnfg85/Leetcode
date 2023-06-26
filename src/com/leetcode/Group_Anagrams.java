package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
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

    public boolean areAnagrams(List<String> one, List<String> two) {
        Collections.sort(one);
        Collections.sort(two);
        if (String.valueOf(one).equals(String.valueOf(two))) {
            return true;
        }
        return false;
    }

    public boolean containsListOfAnagrams(List<List<String>> result, List<String> anagrams) {
        for(List<String> listOfAnagrams : result) {
            if (listOfAnagrams.containsAll(anagrams)) {
                return true;
            }
        }
        return false;
    }
}
