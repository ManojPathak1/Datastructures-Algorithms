// Unique Paths
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3375/

class Solution {
  public int uniquePaths(int m, int n) {
    return factorial(n + m - 2) / (factorial(m - 1) * factorial(n - 1));
  }
  public int factorial(int n) {
    if (n == 1) return 1;
    return n * factorial(n - 1);
  }
}

// Not able to solve, need to find the factorial of a large number.