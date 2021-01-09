// 155. Min Stack
// https://leetcode.com/problems/min-stack/

class MinStack {

  Stack<Integer> stack;
  Stack<Integer> minStack;
  int minVal;

  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
    minVal = Integer.MAX_VALUE;
  }
    
  public void push(int x) {
    stack.push(x);
    minVal = Math.min(minVal, x);
    minStack.push(minVal);
  }
    
  public void pop() {
    stack.pop();
    minStack.pop();
    if (!minStack.isEmpty()) {
      minVal = minStack.peek();
    } else {
      minVal = Integer.MAX_VALUE;   
    }
  }
    
  public int top() {
    return stack.peek();
  }
    
  public int getMin() {
    return minStack.peek();
  }
}