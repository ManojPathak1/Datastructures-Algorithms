//  Search Insert Position
//  https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3356/

class Solution {
  public int searchInsert(int[] nums, int target) {
    int len = nums.length;
    if (target < nums[0]) return 0;
    if (target > nums[len - 1]) return len;
    if (target == nums[len - 1]) return len - 1;
    for (int i = 0; i < len - 1; i++) {
      int e = nums[i];
      if (e == target) return i;
      if (target > nums[i] && target < nums[i + 1]) return i + 1;
    }
    return -1;
  }
}