class Solution {
  public String reverseParentheses(String s) {
    int n = s.length();
    Stack<Character> stack = new Stack<>();
    Queue<Character> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == ')') {
        while (!stack.empty()) {
          char ch2 = stack.pop();
          if (ch2 == '(') break;
          queue.add(ch2);
        }
        while (queue.size() != 0) stack.push(queue.poll());
      } else {
        stack.push(ch);
      }
    }
    String result = "";
    while (!stack.empty()) result += stack.pop();
    String reverse = "";
    for (int i = result.length() - 1; i >= 0; i--) reverse += result.charAt(i);
    return result;
  }
}