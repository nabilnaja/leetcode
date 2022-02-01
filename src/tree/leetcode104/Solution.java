package tree.leetcode104;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++){
            if (index.containsKey(nums[i]))
                return new int [] {index.get(nums[i]), i};
            else
                index.put(target - nums[i], i);
        }
        return null;
    }
}
