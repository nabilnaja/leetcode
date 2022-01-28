package array.leetcode121;

public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < min)
                min = price;
            final int localProfit = price - min;
            if (localProfit > maxProfit)
                maxProfit = localProfit;
        }
        return maxProfit;
    }
}
