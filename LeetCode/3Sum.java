//  3Sum
//  https://leetcode.com/problems/3sum/

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> result = new LinkedList();
    for (int i = 0; i < n - 2; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) continue;
      int l = i + 1;
      int h = n - 1;
      int sum = 0 - nums[i];
      while (l < h) {
        int pairSum = nums[l] + nums[h];
        if (sum == pairSum) {
          result.add(Arrays.asList(nums[i], nums[l], nums[h]));
          while (l < h && nums[l] == nums[l + 1]) l++;
          while (l < h && nums[h] == nums[h - 1]) h--;
          l++;
          h--;
        } else if (sum > pairSum) l++;
        else h--;
      }
    }
    return result;
  }
}