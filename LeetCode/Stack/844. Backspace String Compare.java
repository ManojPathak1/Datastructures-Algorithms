class Solution {
  public boolean backspaceCompare(String s, String t) {
    Stack<Character> modifiedS = postBackspace(s);
    Stack<Character> modifiedT = postBackspace(t);      
    while (!modifiedS.empty() && !modifiedT.empty()) if (modifiedS.pop() != modifiedT.pop()) return false;
    if (!modifiedS.empty() || !modifiedT.empty()) return false;
    return true;
  }

  private Stack<Character> postBackspace(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '#' && !stack.empty()) stack.pop();
      if (ch != '#') stack.push(ch);
    }
    return stack;
  }
}