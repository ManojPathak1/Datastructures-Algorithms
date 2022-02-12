class Solution {
  public int calPoints(String[] ops) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < ops.length; i++) {
      String ch = ops[i];
      switch (ch) {
        case "+":
          int el2 = stack.pop();
          int el1 = stack.pop();
          int el3 = el1 + el2;
          stack.push(el1);
          stack.push(el2);
          stack.push(el3);
          break;
        case "D":
          stack.push(2 * stack.peek());
          break;
        case "C":
          stack.pop();
          break;
        default:
          stack.push(Integer.parseInt(ch));
      }
    }
    int result = 0;
    while (!stack.empty()) result += stack.pop();
    return result;
  }
}