class Solution {
  public String makeGood(String s) {
    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (!stack1.empty() && Character.toLowerCase(ch) == Character.toLowerCase(stack1.peek()) && ch != stack1.peek()) stack1.pop();
      else stack1.push(ch);
    }
    while (!stack1.empty()) stack2.push(stack1.pop());
    while (!stack2.empty()) result += stack2.pop();
    return result;
  }
}