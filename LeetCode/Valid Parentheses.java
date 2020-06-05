//  Valid Parentheses
//  https://leetcode.com/problems/valid-parentheses/

class Solution {
  public boolean isValid(String s) {
    char ch[] = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    for (char e : ch) {
      if (e == '(' || e == '{' || e == '[') stack.push(e);
      else if (e == ')' || e == '}' || e == ']') {
        if (!stack.empty() && ((e == ')' && stack.peek() == '(')
            || (e == '}' && stack.peek() == '{')
            || (e == ']' && stack.peek() == '['))) stack.pop();
        else return false;
      }
    }
    return stack.empty();
  }
}