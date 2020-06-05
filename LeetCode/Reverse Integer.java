//  Reverse Integer
//  https://leetcode.com/problems/reverse-integer/

class Solution {
  public int reverse(int x) {
    boolean isNegative = x < 0;
    if (isNegative) x = 0 - x;
    long n = 0;
    while (x > 0) {
      int rem = x % 10;
      n = n * 10 + rem;
      x = x / 10;
    }
    if (isNegative) n = 0 - n;
    if (n >= -2147483648 && n <= 2147483647) return (int)n;
    return 0;
  }
}