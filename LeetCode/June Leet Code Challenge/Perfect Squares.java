// Perfect Squares
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3373/

class Solution {
  public int numSquares(int n) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, -1);
    dp[1] = 1;
    return recCompute(dp, n, 0);
  }
  public int recCompute(int dp[], int n, int count) {
    if (isPerfectSquare(n)) return count + 1;
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      if (dp[i] == -1) dp[i] = recCompute(dp, i, count);
      if (dp[n - i] == -1) dp[n - i] = recCompute(dp, n - i, count);
      int computedMin = dp[i] + dp[n - i];
      min = Math.min(min, computedMin);
    }
    dp[n] = min;
    return count + min;
  }
  public boolean isPerfectSquare(int x) {
    double sq = Math.sqrt(x);
    return (sq - Math.floor(sq) == 0);
  }
}