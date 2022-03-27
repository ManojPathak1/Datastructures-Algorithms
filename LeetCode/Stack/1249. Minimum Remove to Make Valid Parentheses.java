class Solution {
  public String minRemoveToMakeValid(String s) {
    int open = 0, close = 0;
    String str = "";
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        open++;
        str += ch;
      } else if (open > 0) {
        close--;
        str += ch;
      } else {
        close++;
      }
    }
    String temp = "";
    open = 0;
    close = 0;
    for (int i = str.length() - 1; i >= 0; i--) {
      char ch = str.charAt(i);
      if (ch == ')') {
        close++;
        temp += ch;
      } else if (close > 0) {
        open--;
        temp += ch;
      } else {
        open++;
      }
    }
    str = "";
    for (int i = temp.length() - 1; i >= 0; i--) {
      str += temp.charAt(i);
    }
    return str;
  }
}