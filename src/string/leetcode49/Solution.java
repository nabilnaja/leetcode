package string.leetcode49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static final char CHAR = 'A';
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        for(String str: strs){
            String hash = hash(str);
            ans.putIfAbsent(hash, new ArrayList<>());
            ans.get(hash).add(str);
        }
        return new ArrayList<>(ans.values());
    }
    private String hash(String str){
        int[] count = new int[26];
        for (char c : str.toCharArray())
            count[c - CHAR]++;
        StringBuilder sb = new StringBuilder();
        for (char i = 0; i < 26; i++) {
            if(count[i] != 0){
                sb.append(i);
                sb.append(count[i]);
            }
        }
        return sb.toString();
    }
}


