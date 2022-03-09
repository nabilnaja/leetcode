package string.leetcode76;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public String minWindow(String s, String t) {
        int best = Integer.MAX_VALUE;

        int[] res = new int[2];

        if (t.length() == 0) {
            return "";
        }

        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> tFreq = new HashMap<>();
        Map<Character, Integer> sFreq = new HashMap<>();


        for (char c : t.toCharArray()) {
            tFreq.merge(c, 1, Integer::sum);
        }

        //tFreq.keySet().forEach(c -> sFreq.put(c, 0));

        int needed = tFreq.size();
        int formed = 0;
        int start = 0;
        int end = 0;

        while (end < s.length()) {
            char c = s.charAt(end);

            sFreq.merge(c, 1, Integer::sum);

            if (tFreq.containsKey(c) && sFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }

            while (start <= end && formed == needed) {
                c = s.charAt(start);
                int currentSize = end - start + 1;
                if (currentSize < best) {
                    best = currentSize;
                    res[0] = start;
                    res[1] = end;
                }


                sFreq.computeIfPresent(c, (k, v) -> v - 1);

                if (tFreq.containsKey(c) && sFreq.get(c) < tFreq.get(c)) {
                    formed--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                start++;
            }
            end++;
        }

        return best == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }

}


