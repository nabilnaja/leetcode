package string.leetcode125;

public class Solution {

    public boolean isPalindrome(String s) {
        for(int l = 0, r = s.length() -1; l < r; l++,r--){
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            if( Character.toLowerCase(s.charAt(r))!=Character.toLowerCase(s.charAt(l))){
                return false;
            }
        }
        return true;
    }

}


