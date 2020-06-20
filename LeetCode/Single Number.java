//  Single Number
//  https://leetcode.com/problems/single-number/

class Solution {
  public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int e = nums[i];
			if (hmap.containsKey(e)) hmap.put(e, hmap.get(e) + 1);
			else hmap.put(e, 1);
		}
		for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if (value == 1) return key;
		}
		return -1;
  }
}

//	Expected Time Complexity - O(n), Space Complexity - O(1)
//	Sort the linked list which takes nlogn time complexity.
//	Doing xor of the numbers.

class Solution {
	public int singleNumber(int[] nums) {
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res ^= nums[i];
		}
		return res;
	}
}