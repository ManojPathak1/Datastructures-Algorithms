class Solution {
  public String removeDuplicates(String s) {
    if (s.length() == 0 && s.length() == 1) return s;
    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
        if (!stack1.empty() && s.charAt(i) == stack1.peek()) stack1.pop();
        else stack1.push(s.charAt(i));
    }
    String result = "";
    while (!stack1.empty()) stack2.push(stack1.pop());
    while (!stack2.empty()) result += stack2.pop();
    return result;
  }
}