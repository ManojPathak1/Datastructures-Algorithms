//  Move Zeroes
//  https://leetcode.com/problems/move-zeroes/

class Solution {
  public void moveZeroes(int[] nums) {
    int len = nums.length;
    int zeroIndex = -1;
    for (int i = 0; i < len; i++) {
      int e = nums[i];
      if (e == 0 && zeroIndex == -1) zeroIndex = i;
      if (e != 0 && zeroIndex > -1) {
        nums[zeroIndex] = e;
        nums[i] = 0;
        i = zeroIndex;
        zeroIndex = -1;
      }
    }
  }
}