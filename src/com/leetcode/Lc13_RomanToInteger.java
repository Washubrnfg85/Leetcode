package com.leetcode;

public class Lc13_RomanToInteger {
    public int romanToInt(String s) {
        String[] letters = s.split("");
        int[] numbers = new int[letters.length];

        for (int i = 0; i < letters.length; i++) {
            switch (letters[i]) {
                case "M"-> numbers[i] = 1000;
                case "D"-> numbers[i] = 500;
                case "C"-> numbers[i] = 100;
                case "L"-> numbers[i] = 50;
                case "X"-> numbers[i] = 10;
                case "V"-> numbers[i] = 5;
                case "I"-> numbers[i] = 1;
            }
        }

        int result = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (i < numbers.length - 1 && numbers[i] < numbers[i + 1]) {
                result += numbers[i + 1] - numbers[i];
                i++;
            } else {
                result += numbers[i];
            }
        }

        return result;
    }
}
