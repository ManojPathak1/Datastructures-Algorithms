// Sort Colors
// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/

class Solution {
  public void sortColors(int[] nums) {
    int len = nums.length;
    int zeroes = 0;
    int ones = 0;
    for (int e : nums) {
      if (e == 0) zeroes++;
      else if (e == 1) ones++;
    }
    for (int i = 0; i < len; i++) {
      if (zeroes > 0) {
        nums[i] = 0;
        zeroes--;
      } else if (ones > 0) {
        nums[i] = 1;
        ones--;
      } else {
        nums[i] = 2;
      }
    }
  }
}