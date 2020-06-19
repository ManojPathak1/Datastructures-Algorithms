//  Majority Element
//  https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/

class Solution {
  public int majorityElement(int[] nums) {
    int len = nums.length;
    int majorityCount = (len / 2) + 1;
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int n : nums) {
      if (hm.containsKey(n)) hm.put(n, hm.get(n) + 1);
      else hm.put(n, 1);
    }
    for (Map.Entry<Integer, Integer> entry: hm.entrySet()) {
      if (entry.getValue() >= majorityCount) return entry.getKey();
    }
    return -1;
  }
}