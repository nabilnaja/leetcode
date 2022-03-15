package string.leetcode49;

import java.util.*;

public class Solution2 {

    public static final char CHAR = 'A';

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<Integer, List<String>> ans = new HashMap<>();
        for(String str: strs){
            int hash = hash2(str);
            ans.putIfAbsent(hash, new ArrayList<>());
            ans.get(hash).add(str);
        }
        return new ArrayList<>(ans.values());
    }
    private int hash2(String str){
        int[] count = new int[26];
        for (char c : str.toCharArray())
            count[c - CHAR]++;
        return Arrays.hashCode(count);
    }
}


