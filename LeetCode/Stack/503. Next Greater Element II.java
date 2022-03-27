class Solution {
  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int result[] = new int[n];
    Stack<Integer> stack = new Stack<>();
    stack.push(n - 1);
    for (int i = 2 * n - 2; i >= 0; i--) {
      int index = i % n;
      while (!stack.empty() && nums[index] >= nums[stack.peek()]) stack.pop();
      result[index] = stack.empty() ? -1 : nums[stack.peek()];
      stack.push(index);
    }
    return result;
  }
}