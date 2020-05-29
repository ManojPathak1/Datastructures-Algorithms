//  3Sum Closest
//  https://leetcode.com/problems/3sum-closest/


//  The solution is O(n3).
//  Iterative approach.
class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int n = nums.length;
    int min = Integer.MAX_VALUE;
    int result = -1;
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          int sum = nums[i] + nums[j] + nums[k];
          if (min > Math.abs(sum - target)) {
            result = sum;
            min = Math.abs(sum - target);
          }
        }
      }
    }
    return result;
  }
}

//  Method 2 - The solution is O(n2)

class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int n = nums.length;
    int minDiff = Integer.MAX_VALUE;
    int result = -1;
    Arrays.sort(nums);
    for (int i = 0; i < n - 2; i++) {
      int l = i + 1;
      int h = n - 1;
      while (l < h) {
        int sum = nums[l] + nums[h] + nums[i];
        if (minDiff > Math.abs(sum - target)) {
          minDiff = Math.abs(sum - target);
          result = sum;
        }
        if (sum > target) {
          h--;
        } else {
          l++;
        }
      } 
    }
    return result;
  }
}