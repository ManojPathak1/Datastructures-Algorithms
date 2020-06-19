//  Container With Most Water
//  https://leetcode.com/problems/container-with-most-water/

class Solution {
  public int maxArea(int[] height) {
    int max = 0;
    int i = 0;
    int j = height.length - 1;
    while (i != j) {
      int leftHeight = height[i];
      int rightHeight = height[j];
      max = Math.max(Math.min(leftHeight, rightHeight) * (j - i), max);
      if (leftHeight < rightHeight) i++;
      else j--;
    }
    return max;
  }
}