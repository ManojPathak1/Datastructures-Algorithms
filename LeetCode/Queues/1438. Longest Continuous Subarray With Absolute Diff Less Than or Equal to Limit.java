class Solution {
  public int longestSubarray(int[] nums, int limit) {
    int maxResult = 1;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (maxResult >= n - i) break;
      int max = nums[i], min = nums[i], result = 0;
      for (int j = i; j < n; j++) {
        int el = nums[j];
        max = Math.max(max, el);
        min = Math.min(min, el);
        if (max - min > limit) break;
        result++;
      }
      maxResult = Math.max(maxResult, result);
    }
    return maxResult;
  }
}