//  Single Element in a Sorted Array
//  https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/

class Solution {
  public int singleNonDuplicate(int[] nums) {
    int l = nums.length;
    for (int i = 0; i < l; i++) {
      if (i == l - 1) return nums[i];
      int n1 = nums[i];
      int n2 = nums[i + 1];
      if (n1 != n2) return n1;
      i++;
    }
    return -1;
  }
}

// Need to solve it in O(logn), but the solution here is of O(n).