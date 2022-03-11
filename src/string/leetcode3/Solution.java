package string.leetcode3;

import java.util.HashSet;

public class Solution {

    // todo optimize this solution
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        HashSet<Character> chars = new HashSet<>();

        while (end < s.length()) {
            char c = s.charAt(end);
            if (!chars.add(c)) {
                while (c != s.charAt(start)) {
                    chars.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;

    }

}


