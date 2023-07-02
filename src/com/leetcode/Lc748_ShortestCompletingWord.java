package com.leetcode;


import java.util.*;

public class Lc748_ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String plateIgnoreNumbersAndSpaces = licensePlate.replaceAll("[\\d\" \"]", "").toLowerCase();
        String[] plateLetters = plateIgnoreNumbersAndSpaces.split("");
        Map<String, Integer> countPlateLetters = new HashMap<>();
        countLettersFrequency(countPlateLetters, plateLetters);

        List<String> completingWords = new ArrayList<>();
        for (String word : words) {
            String[] wordLetters = word.split("");
            Map<String, Integer> countWordLetters = new HashMap<>();
            countLettersFrequency(countWordLetters, wordLetters);

            if (checkForAccordance(countPlateLetters, countWordLetters))
                completingWords.add(word);
        }

        if (completingWords.size() < 2) {
            return completingWords.get(0);
        } else {
            return getTheShortestWordFromList(completingWords);
        }
    }

    private void countLettersFrequency(Map<String, Integer> map, String[] array) {
        for (String letter : array) {
            if (map.containsKey(letter)) {
                Integer value = map.get(letter);
                map.put(letter, ++value);
            } else {
                map.put(letter, 1);
            }
        }
    }

    private boolean checkForAccordance(Map<String, Integer> plate, Map<String, Integer> candidate) {
        int count = 0;
        for(Map.Entry<String, Integer> entry : plate.entrySet()) {
            if (candidate.containsKey(entry.getKey()) && candidate.get(entry.getKey()) >= entry.getValue()) {
                count++;
            }
        }
        return  count == plate.size();
    }

    private String getTheShortestWordFromList(List<String> list) {
        int minWordLength = 0;
        String shortestWord = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                minWordLength = list.get(i).length();
                shortestWord = list.get(i);
            } else {
                if (list.get(i).length() < minWordLength) {
                    minWordLength = list.get(i).length();
                    shortestWord = list.get(i);
                }
            }
        }
        return shortestWord;
    }
}
