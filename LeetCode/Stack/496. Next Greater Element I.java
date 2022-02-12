class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < nums2.length; i++) {
      int num = nums2[i];
      while (!stack.empty() && stack.peek() < num) {
        hm.put(stack.pop(), num);
      }
      hm.put(num, -1);
      stack.push(num);
    }
    for (int i = 0; i < nums1.length; i++) {
      nums1[i] = hm.get(nums1[i]);
    }
    return nums1;
  }
}