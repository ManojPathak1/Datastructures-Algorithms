class Solution {
  public int minOperations(String[] logs) {
    Stack<String> stack = new Stack<>();
    for (String log: logs) {
      switch (log) {
        case "../":
          if (!stack.empty()) stack.pop();
          break;
        case "./":
          break;
        default: 
          stack.push(log);
      }
    }
    return stack.size();
  }
}