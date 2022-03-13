package string.leetcode424;

public class Solution {

    public static final char CHAR = 'A';

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0;
        int maxCount = 0;
        int maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - CHAR]);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - CHAR]--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

}


