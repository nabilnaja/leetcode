package string.leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring_1(String s) {
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

    public int lengthOfLongestSubstring_2(String s) {
        int max = 0;
        int start = 0;

        Map<Character, Integer> chars = new HashMap<>();
        for(int end=0; end<s.length(); end++) {
            char c = s.charAt(end);
            if(chars.containsKey(c) && chars.get(c) >= start){
                start = chars.get(c) + 1;
            }
            max = Math.max(max, end - start + 1 );
            chars.put(c, end);
        }
        return max;
    }

}


