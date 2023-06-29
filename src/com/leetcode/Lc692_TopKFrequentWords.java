package com.leetcode;

import java.util.*;

public class Lc692_TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> unicWords = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!unicWords.containsKey(words[i])) {
                unicWords.put(words[i], 1);
            } else {
                unicWords.put(words[i], unicWords.get(words[i]) + 1);
            }
        }

        int maxFreq = Collections.max(unicWords.values());
        List<String> result = new ArrayList<>();

        Set<String> set = new TreeSet<>();
        int count = 0;
        for (int i = maxFreq; i >= maxFreq - k ; i--) {
            for (Map.Entry<String, Integer> entry : unicWords.entrySet()) {
                if (entry.getValue() == i) {
                    set.add(entry.getKey());
                    count++;
                }
            }
            result.addAll(set);
            set.clear();
            if (count >= k) break;
        }

        if (result.size() > k) {
            result = result.subList(0, k);
        }

        return result;
    }
}
