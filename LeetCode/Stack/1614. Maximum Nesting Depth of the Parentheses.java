class Solution {
  public int maxDepth(String s) {
    int result = 0;
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') count++;
      result = Math.max(result, count);
      if (ch == ')') count--;
    }
    return result;
  }
}