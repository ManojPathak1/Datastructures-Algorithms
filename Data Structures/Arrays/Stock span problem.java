// Time Complexity - O(n)
// Space Complexity - O(n)
// Data Structure - Stack is used.

class Solution {
  public static int[] calculateSpan(int price[], int n) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    int span[] = new int[n];
    span[0] = 1;

    for (int i = 1; i < n; i++) {
      int p = price[i];
      while (!stack.isEmpty() && price[stack.peek()] <= p) stack.pop();
      if (stack.isEmpty()) span[i] = i + 1;
      else span[i] = i - stack.peek();
      stack.push(i);
    }

    return span;
  }
}