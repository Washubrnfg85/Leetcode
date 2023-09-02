package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc412_FizzBuzz {
    public List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            String str = "";

            if (i % 3 == 0) {
                str += "Fizz";
            }
            if (i % 5 == 0) {
                str += "Buzz";
            }
            if (i % 7 == 0) {
                str += "Jazz";
            }

            if (!str.equals("")) {
                list.add(str);
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
