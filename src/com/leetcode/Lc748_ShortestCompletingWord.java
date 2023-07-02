package com.leetcode;


import java.util.*;

public class Lc748_ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        //deleting numbers, spaces and casting to lowerCase
        String plateIgnoreNumbersAndSpaces = licensePlate.replaceAll("[\\d\" \"]", "").toLowerCase();
        System.out.println(plateIgnoreNumbersAndSpaces);
        //making an array of letters from plate
        String[] plateLetters = plateIgnoreNumbersAndSpaces.split("");
        //declaring a map to store letter as Key and number of them as Value
        Map<String, Integer> countPlateLetters = new HashMap<>();

        //filling the map
        for (String letter : plateLetters) {
            if (countPlateLetters.containsKey(letter)) {
                Integer value = countPlateLetters.get(letter);
                countPlateLetters.put(letter, ++value);
            } else {
                countPlateLetters.put(letter, 1);
            }
        }

        //declaring a list to store completing words
        List<String> completingWords = new ArrayList<>();
        for (String word : words) {
            //making an array of letters from each word
            String[] wordLetters = word.split("");
            //declaring a map to store word's letters and there quantity
            Map<String, Integer> countWordLetters = new HashMap<>();
            //filling the map
            for (String letter : wordLetters) {
                if (countWordLetters.containsKey(letter)) {
                    Integer value = countWordLetters.get(letter);
                    countWordLetters.put(letter, ++value);
                } else {
                    countWordLetters.put(letter, 1);
                }
            }

            //checking the accordance
            if (checkForAccordance(countPlateLetters, countWordLetters))
                completingWords.add(word);
        }
        System.out.println(completingWords);

        //getting the final answer
        if (completingWords.size() < 2) {
            return completingWords.get(0);
        } else {
            return getTheShortestWordFromList(completingWords);
        }
    }

    //method to check if word (candidate) contains all letters of plate in same of more quantity
    private boolean checkForAccordance(Map<String, Integer> plate, Map<String, Integer> candidate) {
        int count = 0;
        for(Map.Entry<String, Integer> entry : plate.entrySet()) {
            if (candidate.containsKey(entry.getKey()) && candidate.get(entry.getKey()) >= entry.getValue()) {
                count++;
            }
        }
        return  count == plate.size();
    }

    //method to get the shortest word from specified list
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
