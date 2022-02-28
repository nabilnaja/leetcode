package array.leetcode4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int totalSize = (num1Length + num2Length + 1) / 2;
        boolean isEven = (num1Length + num2Length) % 2 == 0;
        int l = 0;
        int r = num1Length;

        while (l <= r) {
            int num1Index = l + (r - l) / 2;
            int num2Index = totalSize - num1Index;

            int maxLeftNums1 = (num1Index == 0) ? Integer.MIN_VALUE : nums1[num1Index - 1];
            int minRightNums1 = (num1Index == num1Length) ? Integer.MAX_VALUE : nums1[num1Index];

            int maxLeftNums2 = (num2Index == 0) ? Integer.MIN_VALUE : nums2[num2Index - 1];
            int minRightNums2 = (num2Index == num2Length) ? Integer.MAX_VALUE : nums2[num2Index];

            if (maxLeftNums1 <= minRightNums2 && maxLeftNums2 <= minRightNums1) {
                if (isEven) {
                    return ((double) Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2;
                } else {
                    return Math.max(maxLeftNums1, maxLeftNums2);
                }
            } else if (maxLeftNums1 > minRightNums2) {
                r = num1Index - 1;
            } else {
                l = num1Index + 1;
            }
        }
        return 0.0;
    }
}
