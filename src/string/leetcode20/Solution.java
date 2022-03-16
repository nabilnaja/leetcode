package string.leetcode20;

import java.util.Map;
import java.util.Stack;

public class Solution {

    private final Map<Character, Character> pairs;

    public Solution() {
        this.pairs = Map.of(')', '(', '}', '{', ']', '[');
    }

    public boolean isValid1(String s) {
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

    public boolean isValid2(String s) {
        if(s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }
            else if(!stack.empty() && c==')' && stack.peek()=='('){
                stack.pop();
            }
            else if(!stack.empty() && c==']' && stack.peek()=='['){
                stack.pop();
            }
            else if(!stack.empty() && c=='}' && stack.peek()=='{'){
                stack.pop();
            }
            else {
                return false;
            }
        }

        return stack.empty();
    }

}


