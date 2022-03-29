package graph.leetcode269;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private final Map<Character, List<Character>> reverseAdjList = new HashMap<>();
    private final Map<Character, Boolean> visited = new HashMap<>();
    private final StringBuilder sortedCharacters = new StringBuilder();

    public String alienOrder(String[] words) {

        for (String word : words) {
            for (char c : word.toCharArray()) {
                reverseAdjList.putIfAbsent(c, new ArrayList<>());
            }
        }


        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }


        for (Character c : reverseAdjList.keySet()) {
            boolean result = dfs(c);
            if (!result) return "";
        }


        if (sortedCharacters.length() < reverseAdjList.size()) {
            return "";
        }
        return sortedCharacters.toString();
    }


    private boolean dfs(Character c) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }
        visited.put(c, false);
        for (Character next : reverseAdjList.get(c)) {
            boolean result = dfs(next);
            if (!result) return false;
        }
        visited.put(c, true);
        sortedCharacters.append(c);
        return true;
    }
}