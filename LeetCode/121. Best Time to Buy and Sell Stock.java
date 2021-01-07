// 121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// Time Complexity O(n^2)
class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int len = prices.length;
    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        int buyPrice = prices[i];
        int sellPrice = prices[j];
        if (sellPrice > buyPrice && (sellPrice - buyPrice) > maxProfit) {
          maxProfit = sellPrice - buyPrice;
        }
      }
    }
    return maxProfit;
  }
}

// Optimized Solution
// Time Complexity: O(n)
// Keep track of the min value and find the max.
class Solution {
  public int maxProfit(int[] prices) {
    int max = 0;
    int min = Integer.MAX_VALUE;
    int len = prices.length;
    for (int i = 0; i < len; i++) {
      int price = prices[i];
      if (price < min) {
        min = price;
      } else {
        max = Math.max(max, price - min);
      }
    }
    return max;
  }
}