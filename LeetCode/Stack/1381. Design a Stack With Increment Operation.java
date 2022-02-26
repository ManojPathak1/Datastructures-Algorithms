class CustomStack {

  private int size = 0;
  private int maxSize;
  private Stack<Integer> stack = new Stack<>();

  public CustomStack(int maxSize) {
    this.maxSize = maxSize;
  }
  
  public void push(int x) {
    if (size < maxSize) {
      stack.push(x);
      size++;
    }
  }
  
  public int pop() {
    if (size > 0) {
      size--;
      return stack.pop();
    }
    return -1;
  }
  
  public void increment(int k, int val) {
    Stack<Integer> tempStack = new Stack<>();
    while (!stack.empty()) tempStack.push(stack.pop());
    while (!tempStack.empty() && k-- > 0) stack.push(tempStack.pop() + val);
    while (!tempStack.empty()) stack.push(tempStack.pop());
  }
}