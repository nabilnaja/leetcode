package string.leetcode5;

public class Solution {

    public String longestPalindrome(String s) {
        int bestStart = 0;
        int bestEnd = 0;
        for(int i = 0; i < s.length(); i++){
            int usingMiddle = isPalindromic(s, i, i);
            int withoutMiddle = isPalindromic(s, i, i + 1);
            int max = Math.max(usingMiddle, withoutMiddle);
            if (max > bestEnd - bestStart) {
                bestStart = i - (max - 1) / 2;
                bestEnd = i + max / 2;
            }
        }
        return s.substring(bestStart, bestEnd + 1);
    }
    private int isPalindromic(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }

}


