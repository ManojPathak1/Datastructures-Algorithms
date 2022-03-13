class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    int pushIndex = 0, popIndex = 0;
    Stack<Integer> stack = new Stack<>();
    while (true) {
      if (!stack.empty() && stack.peek() == popped[popIndex]) {
        stack.pop();
        popIndex++;
      } else {
        if (pushIndex == pushed.length) break;
        stack.push(pushed[pushIndex++]);
      }
    }
    return stack.empty();
  }
}