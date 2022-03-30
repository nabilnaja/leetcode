package divers.leetcode70;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final Map<Integer,Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0)
            return 0;
        if(cache.containsKey(n))
            return cache.get(n);
        int result = climbStairs(n-1) + climbStairs(n-2);
        cache.put(n,result);
        return result;
    }
}
