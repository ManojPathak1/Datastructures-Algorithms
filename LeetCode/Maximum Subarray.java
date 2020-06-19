//  Maximum Subarray
//  https://leetcode.com/problems/maximum-subarray/

class Solution {
  public int maxSubArray(int[] nums) {
    int maxSoFar = nums[0];
    int maxEndingHere = 0;
    for (int i = 0; i < nums.length; i++) {
      int e = nums[i];
      maxEndingHere += e;
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
      if (maxEndingHere < 0) maxEndingHere = 0;
    }
    return maxSoFar;
  }
}