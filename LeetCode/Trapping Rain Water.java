//  Trapping Rain Water
//  https://leetcode.com/problems/trapping-rain-water/

class Solution {
  public int trap(int[] height) {
    int n = height.length;
    if (n == 0) return 0; // During coding forgot this edge case.
    int max = 0;
    int maxFromLeft[] = new int[n];
    int maxFromRight[] = new int[n];
    maxFromLeft[0] = 0;
    maxFromRight[n - 1] = 0;
    max = height[0];
    for (int i = 1; i < n; i++) {
      maxFromLeft[i] = max;
      max = Math.max(height[i], max);
    }
    max = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      maxFromRight[i] = max;
      max = Math.max(height[i], max);
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      int min = Math.min(maxFromLeft[i], maxFromRight[i]);
      if (height[i] < min) result += (min - height[i]); 
    }
    return result;
  }
}