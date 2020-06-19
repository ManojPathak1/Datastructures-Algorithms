//  Climbing Stairs
//  https://leetcode.com/problems/climbing-stairs/

// Concept of fibonacci series.
class Solution {
  public int climbStairs(int n) {
    return stairs(n); 
  }
  private int stairs(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    int a = 1;
    int b = 2;
    int c = a + b;
    for (int i = 3; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return c;
  }
}