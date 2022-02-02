class Solution {
  public int maxResult(int[] nums, int k) {
    return getMaxForIndex(0, nums, k);      
  }
  private int getMaxForIndex(int index, int[] nums, int k) {
    if (index == nums.length - 1) return nums[index];
    int max = getMaxForIndex(index + 1, nums, k);
    for (int i = index + 2, i <= index + k; i++) {
      max = Math.max(max, getMaxForIndex(i, nums, k));
    }
    return nums[index] + max;
  }
}