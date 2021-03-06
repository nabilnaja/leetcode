package array.leetcode11;
public class Solution {
    public int maxArea(int[] height) {
        int maxVol = 0;
        int left = 0;
        int right = height.length -1;
        while(left < right){
            maxVol = Math.max(maxVol, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxVol;
    }
}
