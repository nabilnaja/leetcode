package array.leetcode53;

public class Solution {
    private int[] nums;

    public int maxSubArray(int[] nums) {
        this.nums = nums;

        return findBestSubarray(0, this.nums.length - 1);
    }

    public int findBestSubarray(int l, int r) {
        if(l > r){
            return Integer.MIN_VALUE;
        }
        int mid = Math.floorDiv(l + r, 2);
        int lSum = 0;
        int rSum = 0;
        int curr = 0;

        for (int i = mid - 1; i >= l; i--) {
            curr += nums[i];
            lSum = Math.max(lSum, curr);
        }

        curr = 0;

        for (int i = mid + 1; i <= r; i++) {
            curr += nums[i];
            rSum = Math.max(rSum, curr);
        }

        int mSum = nums[mid] + lSum + rSum;

        int lHalf = findBestSubarray(l, mid - 1);
        int rHalf = findBestSubarray(mid + 1, r);

        return Math.max(mSum, Math.max(lHalf, rHalf));
    }
}
