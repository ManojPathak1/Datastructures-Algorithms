class Solution {
  public String removeOuterParentheses(String s) {
    int count = 0;
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        if (count != 0) result += ch;
        count++;
      } else if (ch == ')') {
        if (count != 1) result += ch;
        count--;
      }
    }
    return result;
  }
}