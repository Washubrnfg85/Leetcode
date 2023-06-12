package com.leetcode;

import java.util.*;

public class Top_K_Frequent_Words {
    public static void main(String[] args) {
        String[] words = new String[]{"bhsmote","sgmjynhhz","mrdcroqasn","mrdcroqasn","jmgch","amdmaic","mrdcroqasn","qyepsbmi","mrdcroqasn","sgmjynhhz","qyepsbmi","sgmjynhhz","sytzfmd","vtnhcbx","sytzfmd","czanzqtuwl","amdmaic","qyepsbmi","czanzqtuwl","qyepsbmi","sgmjynhhz","vtnhcbx","sgmjynhhz","tdtrobarr","vtnhcbx","sgmjynhhz","czanzqtuwl","amdmaic","mrdcroqasn","amdmaic","qyepsbmi","jmgch","qyepsbmi","sgmjynhhz","sgmjynhhz","sytzfmd","bdobr","sgmjynhhz","qyepsbmi","bdobr","czanzqtuwl","qyepsbmi","tdtrobarr","qyepsbmi","sytzfmd","tdtrobarr","mrdcroqasn"};
        System.out.println(topKFrequent(words, 3));
    }

    public static List<String> topKFrequent(String[] words, int k) {
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
