class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 1; i < n; i++) {
      int curr = temperatures[i];
      while (!stack.empty()) {
        if (curr > temperatures[stack.peek()]) {
          int top = stack.pop();
          result[top] = i - top;
        } else break;
      }
      stack.push(i);
    }
    while (!stack.empty()) result[stack.pop()] = 0;
    return result;
  }
}