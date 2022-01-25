class MyQueue {

  private Stack<Integer> stack1, stack2;

  public MyQueue() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
  }
    
  private void transferToStack(Stack<Integer> s1, Stack<Integer> s2) {
    while (!s1.empty()) s2.push(s1.pop());
  }

  public void push(int x) {
    stack1.push(x);
  }

  public int pop() {
    transferToStack(stack1, stack2);
    int val = stack2.pop();
    transferToStack(stack2, stack1);
    return val;
  }
    
  public int peek() {
    transferToStack(stack1, stack2);
    int val = stack2.peek();
    transferToStack(stack2, stack1);
    return val;
  }
    
  public boolean empty() {
    return stack1.empty();
  }
}