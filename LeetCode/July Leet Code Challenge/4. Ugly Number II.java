// Ugly Number II
// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3380/

class Solution {
  public int nthUglyNumber(int n) {
    int nums[] = new int[1695];
    nums[0] = 1;
    if (n == 1) return nums[n - 1];
    int two = 2;
    int three = 3;
    int five = 5;
    int index = 1;
    int prev = 1;
    while (index != n + 3) {
      int min = Math.min(two, Math.min(three, five));
      nums[index] = min;
      if (min == two) two += 2;
      else if (min == three) three += 3;
      else if (min == five) five += 5;
      if (prev != min) index++;
      prev = min;
    }
    return nums[n - 1];
  }
}