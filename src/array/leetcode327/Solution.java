package array.leetcode327;

public class Solution {
    int lower;
    int upper;
    long[] accumulativeSum;

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.upper = upper;
        this.lower = lower;
        accumulativeSum = new long[nums.length + 1];
        //accumulativeSum[0] = nums[0];
        for (int i = 1; i < accumulativeSum.length; i++)
            accumulativeSum[i] = accumulativeSum[i - 1] + nums[i - 1];

        return countRangeSum(0, accumulativeSum.length - 1);
    }

    public int countRangeSum(int l, int r) {
        if (l == r) {
            return 0;
        }

        int mid = l + (r - l) / 2;
        int inRangeCount = countRangeSum(l, mid) + countRangeSum(mid + 1, r);

        int j = mid + 1;
        int k = mid + 1;
        for (int i = l; i <= mid; i++) {
            while (j <= r && accumulativeSum[j] - accumulativeSum[i] < lower)
                j++;
            while (k <= r && accumulativeSum[k] - accumulativeSum[i] <= upper)
                k++;

            inRangeCount += (k - j);
        }
        merge(l, r, mid);
        return inRangeCount;

    }

    private void merge(int l, int r, int mid) {
        long[] helper = new long[r - l + 1];
        if (r + 1 - l >= 0) System.arraycopy(accumulativeSum, l, helper, 0, r + 1 - l);

        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (helper[i - l] < helper[j - l]) {
                accumulativeSum[k] = helper[i - l];
                i++;
                k++;
            } else {
                accumulativeSum[k] = helper[j - l];
                j++;
                k++;
            }
        }
        while (i <= mid) {
            accumulativeSum[k] = helper[i - l];
            i++;
            k++;
        }
    }
}


