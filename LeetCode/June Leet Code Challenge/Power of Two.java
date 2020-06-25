//  Power of Two
//  https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3354/

// Time limit exceeded for the below solution. Need to optimize the solution.
class Solution {
  public boolean isPowerOfTwo(int n) {
    while (n % 2 == 0) n = n / 2;
    return n == 1;
  }
}

//  Using binary operation.
class Solution {
  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & n-1) == 0;
  }
}


