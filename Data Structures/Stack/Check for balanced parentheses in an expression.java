//  Check for balanced parentheses in an expression
//  https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/

import java.util.*;

class Main {
  public static void main(String args[]) {
    System.out.println(isBalancedParanthesis("[()]{}{[()(())]()}"));
  }
  public static boolean isBalancedParanthesis(String str) {
    Stack<Character> stk = new Stack<>();
    char ch[] = str.toCharArray();
    for (int i = 0; i < ch.length; i++) {
      char e = ch[i];
      if (stk.empty()) stk.push(e); 
      else if (stk.peek() == '(' && e == ')') stk.pop();
      else if (stk.peek() == '{' && e == '}') stk.pop();
      else if (stk.peek() == '[' && e == ']') stk.pop();
      else stk.push(e);
    }
    return stk.empty();
  }
}