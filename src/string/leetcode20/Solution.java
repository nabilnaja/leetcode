package string.leetcode20;

import java.util.Map;
import java.util.Stack;

public class Solution {

    private final Map<Character, Character> pairs;

    public Solution() {
        this.pairs = Map.of(')', '(', '}', '{', ']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || pairs.get(c) != stack.pop())
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}


