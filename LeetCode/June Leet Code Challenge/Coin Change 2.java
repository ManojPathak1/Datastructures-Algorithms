//  Coin Change 2
//  https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3353/

class Solution {
  public int change(int amount, int coins[]) {
    int dp[] = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }
}

// Not able to solve the problem. Need to solve it again.