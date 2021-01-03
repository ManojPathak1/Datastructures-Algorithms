//  27. Remove Element
//  https://leetcode.com/problems/remove-element/

class Solution {
  public int removeElement(int[] nums, int val) {
    int index = 0;
    for (int n : nums) {
      if (n != val) {
        nums[index++] = n;
      }
    }
    return index;
  }
}