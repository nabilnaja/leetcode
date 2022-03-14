package string.leetcode242;

public class Solution {

    public static final char CHAR = 'a';

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] charDict = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charDict[s.charAt(i) - CHAR]++;
            charDict[t.charAt(i) - CHAR]--;
        }
        for (int count : charDict)
        {
            if (count != 0)
                return false;
        }
        return true;
    }

}


