package com.leetcode;

import java.util.Stack;

public class Lc20_ValidParentheses {
    public boolean isValid(String s) {

        if (s.length() % 2 != 0) return false;
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (stack.empty() && ((s.charAt(i) == ')') || (s.charAt(i) == ']') ||(s.charAt(i) == '}'))) {
                return false;
            } else if ((s.charAt(i) == ')' && stack.peek() == '(') ||
                    (s.charAt(i) == ']' && stack.peek() == '[') ||
                    (s.charAt(i) == '}' && stack.peek() == '{')) {
                stack.pop();
            } else {
                return false;
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
